package Model;

import Util.PythonConnector;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmSolitareTest {


    AlgorithmSolitareTest() throws IOException {
    }

    @org.junit.jupiter.api.Test
    void winRate() throws IOException {
        PythonConnector pythonConnector = new PythonConnector(false);
        GameModel gameModel = new GameModel(pythonConnector);
        AlgorithmSolitare algo = new AlgorithmSolitare(gameModel);

        int won = 0;
    int lost = 0;
        for (int i = 0; i <100000 ; i++) {
            pythonConnector = new PythonConnector(false);
            gameModel = new GameModel(pythonConnector);
            algo  = new AlgorithmSolitare(gameModel);

            while (true){
            gameModel = algo.nextMove(gameModel.getCardPiles());
            if (gameModel.isGameDone()){
                if (gameModel.isGameWon()){
                    won++;
                }
                if (gameModel.isGameLost()) {
                    lost++;
                }
             break;
            }
            }
        }
        System.out.println("Games won: " + won);
        System.out.println("Games lost: " + lost);
    }
}