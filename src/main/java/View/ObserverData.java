package View;

import Model.GameModel;
import Simulation.SimGame;
import Util.Observer;

public class ObserverData extends Observer {

    GuiController gucci;

    public ObserverData (GuiController guiController, SimGame simGame){
        this.simGame = simGame;
        this.simGame.attach(this);
        gucci = guiController;
    }

    SimGame model = new SimGame();

    public void setModel(SimGame model) {
        this.model = model;
    }

    public SimGame getModel() {
        return model;
    }



    @Override
    public void update() {
        setModel(simGame);
        gucci.updateView();
    }
}
