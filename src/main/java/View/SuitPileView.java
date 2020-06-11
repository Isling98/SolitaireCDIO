package View;

import Model.Card;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.LinkedList;


public class SuitPileView extends StackPane {

    public SuitPileView(LinkedList<Card> suitPile) {
        setPadding(new Insets(5));
        setStyle("-fx-border-color: lightgreen;" + "-fx-border-width: 3;" + "-fx-border-radius: 10.0");

        ImageView image;

        String imgString = "";
        if (suitPile.isEmpty()) {
            image = new ImageView();
            image.setVisible(false);
        }
        else {
            image = new ImageView(suitPile.getFirst().toString());
            getChildren().add(image);
            image.setVisible(true);

        }


        getChildren().add(image);
    }
}
