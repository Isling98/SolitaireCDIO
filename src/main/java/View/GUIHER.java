package View;

import Model.Piles.CardPile;
import Simulation.SimGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUIHER extends Application {


    //Brug denne simulator for nu
    SimGame simGame = new SimGame();
    CardPile[] simPiles = simGame.cardPiles;

    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private DeckPileView deckPileView = new DeckPileView();
    private DiscardView discardView = new DiscardView();
   // private SuitPileView[] suitPileView = new SuitPileView[4];
    private GamePileView[] gamePileViews = new GamePileView[7];

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: green");
        root.add(deckPileView,0,0);
        root.add(discardView, 1,0);

        for(int i=1; i<=4; i++) {
            SuitPileView suitPileView = new SuitPileView();
            root.add(suitPileView, 3+i, 0);
        }
        for(int i=0; i<7; i++){
            gamePileViews[i] = new GamePileView(i, simPiles);
            root.add(gamePileViews[i], i+1, 1);
        }
        Scene solitaireScene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setResizable(false);
        primaryStage.setTitle("7-kabale");
        primaryStage.setScene(solitaireScene);
        primaryStage.show();
    }
}