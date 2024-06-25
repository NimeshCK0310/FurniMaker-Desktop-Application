import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Room extends Application {

    private static final float WIDTH = 1000;
    private static final float HEIGHT = 800;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Camera camera = new PerspectiveCamera(true);

        prepareBackground(root);
        prepareFurnitureItem(root, "/resources/wood.jpg", -100, -50, -400); // Example item
        prepareIcon(root, 0, -100, -600);

        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.translateZProperty().set(-900);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        initMouseControl(root, scene, camera);

        primaryStage.setTitle("3D Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void prepareBackground(Group root) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(Room.class.getResourceAsStream("/resources/v.jpg")));
        Box wall = new Box(5000, 3000, 1);
        wall.setMaterial(material);
        wall.setTranslateZ(-2500);
        root.getChildren().add(wall);
    }

    private void prepareFurnitureItem(Group root, String texturePath, double x, double y, double z) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(Room.class.getResourceAsStream(texturePath)));

        Box item = new Box(100, 100, 100);
        item.setMaterial(material);
        item.setTranslateX(x);
        item.setTranslateY(y);
        item.setTranslateZ(z);

        root.getChildren().add(item);
    }

    private void prepareIcon(Group root, double x, double y, double z) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.AQUA);
        Sphere icon = new Sphere(50);
        icon.setMaterial(material);
        icon.setTranslateX(x);
        icon.setTranslateY(y);
        icon.setTranslateZ(z);

        root.getChildren().add(icon);
    }

    private void initMouseControl(Group root, Scene scene, Camera camera) {
        Rotate xRotate = new Rotate(0, Rotate.X_AXIS);
        Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);

        camera.getTransforms().addAll(xRotate, yRotate);

        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        scene.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });

        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleY.set(anchorAngleY + anchorX - event.getSceneX());
        });

        scene.addEventHandler(ScrollEvent.SCROLL, event -> {
            double delta = event.getDeltaY();
            camera.translateZProperty().set(camera.getTranslateZ() + delta);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
