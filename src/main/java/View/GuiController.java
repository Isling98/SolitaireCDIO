package View;

import Model.Piles.CardPile;
import Simulation.SimGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

public class GuiController extends Application {

    public void setCardPiles(CardPile[] cardPiles) {
        this.cardPiles = cardPiles;
    }

    //Brug denne simulator for nu
  CardPile[] cardPiles;
  SimGame simGame = new SimGame();

    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private DeckPileView deckPileView;
    private DiscardView discardView;
    private SuitPileView[] suitPileView = new SuitPileView[4];
   // private SuitPileView[] suitPileView = new SuitPileView[4];
    private GamePileView[] gamePileViews = new GamePileView[7];


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void init() throws Exception {
    cardPiles = simGame.cardPiles;
        deckPileView = new DeckPileView(cardPiles[7].linkedCards);
        discardView = new DiscardView(cardPiles[8].linkedCards);
    super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: green");
        root.add(deckPileView,0,0);
        root.add(discardView, 1,0);

        for(int i=0; i<4; i++) {
            suitPileView[i] = new SuitPileView(cardPiles[9+i].linkedCards);
            root.add(suitPileView[i], 3+i, 0);
        }

        for(int i=0; i<7; i++){
            gamePileViews[i] = new GamePileView(i, cardPiles);
            root.add(gamePileViews[i], i+1, 1);
        }

        Scene solitaireScene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setResizable(false);
        primaryStage.setTitle("7-kabale");
        primaryStage.setScene(solitaireScene);
        primaryStage.show();
    }

}