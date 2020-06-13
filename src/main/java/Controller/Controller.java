package Controller;

import Model.AlgorithmSolitare;
import Model.Piles.CardPile;
import Simulation.SimGame;
import Util.PythonConnector;
import View.GuiController;

public class Controller {


    public static void main(String[] args) throws Exception {
        //PythonConnector pythonConnector = new PythonConnector();
        // CardPile[] cardPiles = pythonConnector.getGameModel().getCardPiles();

        SimGame observable = new SimGame();
        // GuiController gui = new GuiController();
        AlgorithmSolitare algo = new AlgorithmSolitare(observable);
        observable.attach(algo);

   /*     new Thread(){
            @Override
            public void run(){
                javafx.application.Application.launch();
            }
        }.start();*/


    observable.setCardPiles(algo.startAlgorithm(observable.getCardPiles()));



    }




}
