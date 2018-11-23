package lab2;

import java.awt.*;

public abstract class Vehicle{
    protected Color color;
    protected final double enginePower;
    private final String modelName;
    protected int numberOfDoors = 4;
    private State state;

    public Vehicle(final int numberOfDoors,
                   final Color color,
                   final double enginePower,
                   final String modelName) {
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.numberOfDoors = numberOfDoors;
        this.state = State.PARKED;
    }

    public enum State{
        WORKING,
        BROKEN,
        PARKED;
    }

    public State getState() { return this.state; }

    public void setState(State state) { this.state = state; }
}