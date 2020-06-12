package View;

import Model.Card;
import Model.GameModel;
import Model.Piles.CardPile;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.LinkedList;


public class GamePileView extends StackPane {

    private int index;
    private CardPile[] cardPiles;

    public GamePileView(int index, CardPile[] cardPiles) {
        this.index = index;
        this.cardPiles = cardPiles;
        setPadding(new Insets(5));

        createPiles();
    }

    private void createPiles(){
        LinkedList<Card> cards = cardPiles[index].linkedCards;

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(cards.size()-1-i);
            ImageView imageView = new ImageView(Cards.getImage(card.toString()));
            imageView.setTranslateY(20*i);
            getChildren().add(imageView);
        }
    }
}