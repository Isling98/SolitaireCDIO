package View;

import Model.Card;
import Model.Piles.CardPile;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.LinkedList;


public class DeckPileView extends HBox {
    ImageView imageView;
    public DeckPileView(LinkedList<Card> cardPile){
        setPadding(new Insets(10));
        imageView = new ImageView(Cards.getImage(cardPile.getFirst().toString()));
        getChildren().add(imageView);
    }


    public void updateView(CardPile cardPile) {
        getChildren().clear();

        if (cardPile.isEmpty()) {
            imageView.setVisible(false);
            getChildren().add(imageView);
        } else {
            Card card = cardPile.linkedCards.get(cardPile.getSize() - 1);
            ImageView imageView = new ImageView(Cards.getImage("fd"));
            getChildren().add(imageView);
        }
    }
}

