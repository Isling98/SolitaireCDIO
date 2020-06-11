package Controller;

import Model.AlgorithmSolitare;
import Model.Piles.CardPile;
import Simulation.SimGame;
import Util.PythonConnector;

import java.io.IOException;

public class Controller {


    public static void main(String[] args) throws IOException {
       // PythonConnector pythonConnector = new PythonConnector();
        CardPile[] cardPiles = new SimGame().cardPiles;
       // CardPile[] cardPiles = pythonConnector.getGameModel().getCardPiles();
        AlgorithmSolitare algo = new AlgorithmSolitare(cardPiles);
        algo.firstPrio();




    }




}
