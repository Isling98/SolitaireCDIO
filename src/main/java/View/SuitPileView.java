package View;

import Model.Card;
import Model.Piles.CardPile;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.LinkedList;


public class SuitPileView extends StackPane {
    ImageView image;


    public SuitPileView(LinkedList<Card> suitPile) {
        setPadding(new Insets(5,0,5,0));
        setStyle("-fx-border-color: lightgreen;" + "-fx-border-width: 3;" + "-fx-border-radius: 10.0");
            image = new ImageView();
            image.setVisible(false);
            getChildren().add(image);
    }


    public void createPiles(CardPile cardPile){
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

