package main.java.View;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.java.View.Cards;

public class DiscardView extends HBox {

    public DiscardView() {

        setPadding(new Insets(10));
        ImageView image = new ImageView(Cards.getFaceDownCard());

        getChildren().add(image);

        image.setVisible(false);
    }
}
