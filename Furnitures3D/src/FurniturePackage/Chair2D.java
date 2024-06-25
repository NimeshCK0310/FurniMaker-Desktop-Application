package FurniturePackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Chair2D {

    public Group createChairView() {
        Image woodImage = new Image(getClass().getResourceAsStream("/resources/wood.jpg"));
        ImagePattern woodPattern = new ImagePattern(woodImage);

        Group root = new Group();

        Rectangle seat = new Rectangle(100, 20);
        seat.setFill(woodPattern);
        seat.setX(200); // X position of the seat
        seat.setY(180); // Y position of the seat

        Rectangle backrest = new Rectangle(80, 100);
        backrest.setFill(woodPattern);
        backrest.setX(seat.getX() + (seat.getWidth() - backrest.getWidth()) / 2); // Centered on the seat
        backrest.setY(seat.getY() - backrest.getHeight()); // Above the seat

        Rectangle leg1 = new Rectangle(20, 50);
        leg1.setFill(woodPattern);
        leg1.setX(seat.getX());
        leg1.setY(seat.getY() + seat.getHeight());

        Rectangle leg2 = new Rectangle(20, 50);
        leg2.setFill(woodPattern);
        leg2.setX(seat.getX() + seat.getWidth() - leg2.getWidth());
        leg2.setY(seat.getY() + seat.getHeight());

        root.getChildren().addAll(seat, backrest, leg1, leg2);

        return root;
    }
}
