package lab1;

import java.awt.*;

public abstract class Car {
  protected int nrDoors;
  protected double enginePower;
  protected double currentSpeed;
  protected Color color;
  protected String modelName;

  public int getNrDoors() {
    return nrDoors;
  }

  public double getEnginePower() {
    return enginePower;
  }

  public double getCurrentSpeed() {
    return currentSpeed;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(final Color color) {
    this.color = color;
  }

  public void startEngine() {
    currentSpeed = 0.1;
  }

  public void stopEngine() {
    currentSpeed = 0;
  }

  public void incrementSpeed(final double amount) {
    currentSpeed = getCurrentSpeed() + speedFactor() * amount;
  }

  public void decrementSpeed(final double amount) {
    currentSpeed = getCurrentSpeed() - speedFactor() * amount;
  }

  public abstract double speedFactor();

  // TODO fix this method according to lab pm
  public void gas(double amount) {
    incrementSpeed(amount);
  }

  // TODO fix this method according to lab pm
  public void brake(double amount) {
    decrementSpeed(amount);
  }
}
