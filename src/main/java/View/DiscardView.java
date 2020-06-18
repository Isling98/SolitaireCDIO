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

        setPadding(new Insets(10,0,10,0));

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
        getChildren().clear();
        if (cardPile.isEmpty()){
            image.setVisible(false);
            getChildren().add(image);
        }
        else {

        Card card = cardPile.linkedCards.getFirst();
        ImageView imageView = new ImageView(Cards.getImage(card.toString()));
        getChildren().add(imageView);
        }
    }
}
