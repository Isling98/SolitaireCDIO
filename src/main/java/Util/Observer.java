package Util;

import Simulation.SimGame;

public abstract class Observer {
    // Skal ændres når openCV kommer på
    protected SimGame simGame;
    public abstract void update();
}
