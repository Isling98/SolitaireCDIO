package View;

import Model.Card;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;



public class SuitPileView extends StackPane {

    public SuitPileView() {
        setPadding(new Insets(5));
        setStyle("-fx-border-color: lightgreen;" + "-fx-border-width: 3;" + "-fx-border-radius: 10.0");
        ImageView image = new ImageView(Card.get());
        image.setVisible(false);
        getChildren().add(image);

    }
}
