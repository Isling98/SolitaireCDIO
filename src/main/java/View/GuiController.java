package View;

import Model.AlgorithmSolitare;
import Model.GameModel;
import Simulation.SimGame;
import Util.PythonConnector;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.LiteralNode;

import java.io.IOException;
import java.util.Iterator;


public class GuiController extends Application  {


    //Brug denne simulator for nu

    GameModel gameModel = new GameModel();
   // ObserverData observerData = new ObserverData(gameModel);
    AlgorithmSolitare algo = new AlgorithmSolitare();
    Label msg = new Label();
    private static final int HEIGHT = 600;
    private static final int WIDTH = 1000;
    private DeckPileView deckPileView;
    private DiscardView discardView;
    private SuitPileView[] suitPileView = new SuitPileView[4];
    private GamePileView[] gamePileViews = new GamePileView[7];
    GridPane root;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new GridPane();
        root.setStyle("-fx-background-color: green");

        gameModel.setCardPiles(new SimGame().getCardPiles());
        deckPileView = new DeckPileView(gameModel.getCardPiles()[7].linkedCards);
        discardView = new DiscardView(gameModel.getCardPiles()[8].linkedCards);

        for (int i = 0; i < 4; i++) {
            suitPileView[i] = new SuitPileView(gameModel.getCardPiles()[9 + i].linkedCards);
            root.add(suitPileView[i], 3 + i, 0);
        }

        for (int i = 0; i < 7; i++) {
            gamePileViews[i] = new GamePileView(gameModel.getCardPiles()[i]);
            root.add(gamePileViews[i], i + 1, 1);
        }
        root.add(deckPileView, 0, 0);
        root.add(discardView, 1, 0);



        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
               makeMove(root);
            }
        };

        msg.setFont(Font.font("Veranda", 25));
        msg.setTranslateY(300);
        msg.setWrapText(true);
        root.add(msg,8,6);
        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        Scene solitaireScene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setResizable(false);
        primaryStage.setTitle("7-kabale");
        primaryStage.setScene(solitaireScene);
        primaryStage.show();
    }


    public void makeMove(GridPane root)   {
            gameModel = algo.nextMove(gameModel.getCardPiles());
            update();

    }
    public void update(){

        msg.setText(gameModel.toString());

        for (int i = 0; i < 7; i++) {
            gamePileViews[i].createPiles(gameModel.getCardPiles()[i]);
        }
        for (int i = 0; i < 4; i++) {
            suitPileView[i].createPiles(gameModel.getCardPiles()[i+9]);
        }

        discardView.updateView(gameModel.getCardPiles()[8]);
        deckPileView.updateView(gameModel.getCardPiles()[7]);

    }
}
