package View;

import Model.GameModel;
import Simulation.SimGame;
import Util.Observer;

public class ObserverData extends Observer   {


    GameModel gameModel;
    public ObserverData (GameModel gameModel){
        this.gameModel = gameModel;
        this.gameModel.attach(this);
    }

    GameModel model = new GameModel();

    public void setModel(GameModel model) {
        this.model = model;
    }

    public GameModel getModel() {
        return model;
    }



    @Override
    public void update() {
        setModel(gameModel);
    }

}
