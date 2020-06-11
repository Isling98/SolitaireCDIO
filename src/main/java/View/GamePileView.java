package View;

import Model.Card;
import Model.GameModel;
import Model.Piles.CardPile;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.LinkedList;


public class GamePileView extends StackPane{

    private int index;
    private CardPile[] cardPiles;

    public GamePileView(int index, CardPile[] cardPiles) {
        this.index = index;
        this.cardPiles = cardPiles;
        setPadding(new Insets(5));

        createPiles();
    }

    private void createPiles(){
        int base = 0;
        LinkedList<Card> cards = cardPiles[index].linkedCards;

        for(Card card: cards){
            ImageView imageView = new ImageView(Cards.getImage(card.toString()));
            imageView.setTranslateY(17*base);
            getChildren().add(imageView);
            base++;

        }
    }
}