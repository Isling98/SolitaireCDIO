package View;

import Model.Card;
import Model.GameModel;
import Model.Piles.CardPile;
import Model.Piles.GamePile;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.LinkedList;


public class GamePileView extends StackPane {

    private CardPile gamePile;

    public GamePileView(CardPile cardPile) {
        gamePile = cardPile;
        setPadding(new Insets(5));
        createPiles(cardPile);
    }

    public void createPiles(CardPile cardPile){
        getChildren().clear();

        // blot indsat disse kort og sat dem invisable så bunkerne ikke rykker sig når de er tomme.
        ImageView placeholder = new ImageView(Cards.getImage("fd"));
        placeholder.setVisible(false);
        getChildren().add(placeholder);

        for (int i = cardPile.getSize()-1; i >= 0; i--) {
            Card card = cardPile.linkedCards.get(i);
            ImageView imageView = new ImageView(Cards.getImage(card.toString()));
            imageView.setTranslateY(20*(cardPile.getSize()-i));
            getChildren().add(imageView);
        }
    }
}