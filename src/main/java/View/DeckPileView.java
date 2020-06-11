package View;

import Model.Card;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.LinkedList;


public class DeckPileView extends HBox {

    public DeckPileView(LinkedList<Card> cardPile){
        setPadding(new Insets(10));
        ImageView imageView = new ImageView(Cards.getImage(cardPile.getFirst().toString()));
        getChildren().add(imageView);
    }
}
