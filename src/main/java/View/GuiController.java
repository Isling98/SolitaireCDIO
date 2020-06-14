package View;

import Controller.Controller;
import Model.AlgorithmSolitare;
import Model.GameModel;
import Model.Piles.CardPile;
import Simulation.SimGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.Timer;

public class GuiController extends Application  {


    //Brug denne simulator for nu

    GameModel gameModel = new GameModel();
    ObserverData observerData = new ObserverData(gameModel);
    AlgorithmSolitare algo = new AlgorithmSolitare();
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
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



        gameModel.setCardPiles(new SimGame().getCardPiles());
        deckPileView = new DeckPileView(gameModel.getCardPiles()[7].linkedCards);
        discardView = new DiscardView(gameModel.getCardPiles()[8].linkedCards);


        root = new GridPane();
        root.setStyle("-fx-background-color: green");
        root.add(deckPileView, 0, 0);
        root.add(discardView, 1, 0);


        for (int i = 0; i < 4; i++) {
            suitPileView[i] = new SuitPileView(gameModel.getCardPiles()[9 + i].linkedCards);
            root.add(suitPileView[i], 3 + i, 0);
        }

        for (int i = 0; i < 7; i++) {
            gamePileViews[i] = new GamePileView(gameModel.getCardPiles()[i]);
            root.add(gamePileViews[i], i + 1, 1);
        }


        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
               makeMove(root);

            }
        };

        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        Scene solitaireScene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setResizable(false);
        primaryStage.setTitle("7-kabale");
        primaryStage.setScene(solitaireScene);
        primaryStage.show();
    }


    public void makeMove(GridPane root){
            gameModel.setCardPiles(algo.startAlgorithm(gameModel.getCardPiles()));
            update(root);

    }
    public void update(GridPane root){

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
