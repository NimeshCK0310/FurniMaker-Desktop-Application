package FurniturePackage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Cupboard2D {

    public static Group createCupboardView() {
        Image woodImage = new Image(Cupboard2D.class.getResourceAsStream("/resources/wood.jpg"));
        ImagePattern woodPattern = new ImagePattern(woodImage);

        Group root = new Group();

        // Create the body of the cupboard
        Rectangle body = new Rectangle(200, 300);
        body.setFill(woodPattern);
        body.setX(150); // X position of the cupboard body
        body.setY(50); // Y position of the cupboard body

        // Doors of the cupboard, positioned to appear open
        Rectangle doorLeft = new Rectangle(50, 290); // Thinner to simulate the door being open
        doorLeft.setFill(woodPattern);
        doorLeft.setX(body.getX() - doorLeft.getWidth()); // Positioned to the left, appearing open
        doorLeft.setY(body.getY() + 5); // Slightly inside the body

        Rectangle doorRight = new Rectangle(50, 290); // Thinner to simulate the door being open
        doorRight.setFill(woodPattern);
        doorRight.setX(body.getX() + body.getWidth()); // Positioned to the right, appearing open
        doorRight.setY(body.getY() + 5); // Slightly inside the body

        // Shelves inside the cupboard
        Rectangle shelf1 = new Rectangle(190, 10);
        shelf1.setFill(woodPattern);
        shelf1.setX(body.getX() + 5);
        shelf1.setY(100);

        Rectangle shelf2 = new Rectangle(190, 10);
        shelf2.setFill(woodPattern);
        shelf2.setX(body.getX() + 5);
        shelf2.setY(200);

        // Add all components to the root group
        root.getChildren().addAll(body, doorLeft, doorRight, shelf1, shelf2);

        return root;
    }
}
