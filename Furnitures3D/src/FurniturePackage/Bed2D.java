package FurniturePackage;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Bed2D {

    public static Group createBedView() {
        Image woodImage = new Image(Bed2D.class.getResourceAsStream("/resources/wood.jpg"));
        ImagePattern woodPattern = new ImagePattern(woodImage);

        Group root = new Group();

        Rectangle mattress = new Rectangle(200, 30);
        mattress.setFill(woodPattern);
        mattress.setX(150);
        mattress.setY(150);

        Rectangle leg1 = new Rectangle(20, 40);
        leg1.setFill(woodPattern);
        leg1.setX(mattress.getX());
        leg1.setY(mattress.getY() + mattress.getHeight());

        Rectangle leg2 = new Rectangle(20, 40);
        leg2.setFill(woodPattern);
        leg2.setX(mattress.getX() + mattress.getWidth() - leg2.getWidth());
        leg2.setY(mattress.getY() + mattress.getHeight());

        Rectangle leg3 = new Rectangle(30, 40);
        leg3.setFill(woodPattern);
        leg3.setX(mattress.getX());
        leg3.setY(mattress.getY() - leg3.getHeight());

        Rectangle leg4 = new Rectangle(30, 40);
        leg4.setFill(woodPattern);
        leg4.setX(mattress.getX() + mattress.getWidth() - leg4.getWidth());
        leg4.setY(mattress.getY() - leg4.getHeight());

        root.getChildren().addAll(mattress, leg1, leg2, leg3, leg4);

        return root;
    }
}
