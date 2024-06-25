package FurniturePackage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Table2D {

    public static Group createTableView() {
        Image woodImage = new Image(Table2D.class.getResourceAsStream("/resources/wood.jpg"));
        ImagePattern woodPattern = new ImagePattern(woodImage);

        Group root = new Group();

        // Create the tabletop with the wood image pattern
        Rectangle tabletop = new Rectangle(300, 30);
        tabletop.setFill(woodPattern);
        tabletop.setX(100); // X position of the tabletop
        tabletop.setY(150); // Y position of the tabletop

        // FurniturePackage.Table legs - adjust the position according to the tabletop's position
        Rectangle leg1 = new Rectangle(20, 100);
        leg1.setFill(woodPattern);
        leg1.setX(tabletop.getX());
        leg1.setY(tabletop.getY() + tabletop.getHeight());

        Rectangle leg2 = new Rectangle(20, 100);
        leg2.setFill(woodPattern);
        leg2.setX(tabletop.getX() + tabletop.getWidth() - leg2.getWidth());
        leg2.setY(tabletop.getY() + tabletop.getHeight());

        // Optional: Adding additional legs for better stability in representation
        Rectangle leg3 = new Rectangle(20, 100);
        leg3.setFill(woodPattern);
        leg3.setX(tabletop.getX() + tabletop.getWidth() / 3 - leg3.getWidth() / 2);
        leg3.setY(tabletop.getY() + tabletop.getHeight());

        Rectangle leg4 = new Rectangle(20, 100);
        leg4.setFill(woodPattern);
        leg4.setX(tabletop.getX() + 2 * (tabletop.getWidth() / 3) - leg4.getWidth() / 2);
        leg4.setY(tabletop.getY() + tabletop.getHeight());

        // Add all components to the root group
        root.getChildren().addAll(tabletop, leg1, leg2, leg3, leg4);


        return root;
    }


}
