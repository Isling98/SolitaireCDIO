package View;

import Model.Card;
import Model.GameModel;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;



public class GamePileView extends StackPane{

    private int index;

    public GamePileView(int index) {
        this.index = index;
        setPadding(new Insets(5));

        createPiles();
    }

    private void createPiles(){
        int base = 0;
        Card[] cards = GameModel.getINSTANCE().getCardPiles(index);

        for(Card card: cards){
            ImageView imageView = new ImageView(Cards.getFaceDownCard());
            imageView.setTranslateY(17*base);
            getChildren().add(imageView);
            base++;

        }
    }
}