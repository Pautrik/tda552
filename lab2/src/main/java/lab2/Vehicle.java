package lab2;

import java.awt.*;

public abstract class Vehicle{
    protected Color color;
    protected final double enginePower;
    private final String modelName;
    private State state;

    public Vehicle(final Color color,
                   final double enginePower,
                   final String modelName) {
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.state = State.PARKED;
    }

    public enum State{
        WORKING,
        BROKEN,
        PARKED
    }

    protected State getState() { return this.state; }

    public void setState(State state) { this.state = state; }
}