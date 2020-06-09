package main.java.View;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.java.View.Cards;

public class DeckPileView extends HBox {

    public DeckPileView(){
        setPadding(new Insets(10));
        ImageView imageView = new ImageView(Cards.getFaceDownCard());
        getChildren().add(imageView);
    }
}
