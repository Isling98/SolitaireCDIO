package View;

import Model.Card;
import Model.Piles.CardPile;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.LinkedList;

public class DiscardView extends HBox {

    ImageView image;
    public DiscardView(LinkedList<Card> cardPile) {

        setPadding(new Insets(10));

        String imgString = "";
        if (cardPile.isEmpty()) {
            image = new ImageView();
            image.setVisible(false);
        }
        else {
            image = new ImageView(cardPile.getLast().toString());
            getChildren().add(image);
            image.setVisible(true);
        }
    }

    public void updateView(CardPile cardPile){
        if (cardPile.isEmpty()){
            image.setVisible(false);
        }
        else {
        getChildren().clear();
        Card card = cardPile.linkedCards.getFirst();
        ImageView imageView = new ImageView(Cards.getImage(card.toString()));
        getChildren().add(imageView);
        }
    }
}
