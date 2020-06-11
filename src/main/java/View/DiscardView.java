package View;

import Model.Card;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.LinkedList;

public class DiscardView extends HBox {

    public DiscardView(LinkedList<Card> cardPile) {

        setPadding(new Insets(10));

        String imgString = "";
        if (cardPile.isEmpty()) {
            ImageView image = new ImageView();
            image.setVisible(false);
        }
        else {
            ImageView image = new ImageView(cardPile.getLast().toString());
            getChildren().add(image);
            image.setVisible(true);

        }



    }
}
