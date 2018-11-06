package lab1;

import java.awt.*;

public abstract class Car implements Movable {
  protected Color color;
  protected double currentSpeed;
  protected double enginePower;
  protected String modelName;
  protected int nrDoors = 4;
  protected int x;
  protected int y;
  protected Direction direction = Direction.UP;

  public enum Direction {
    UP,
    RIGHT,
    LEFT,
    DOWN;

    public Direction getNext() {
      return values()[(ordinal() + 1) % values().length];
    }

    public Direction getPrevious() {
      return values()[(ordinal() - 1) % values().length];
    }
  };

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

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void move() {
    switch (this.direction) {
      case UP:
        this.y += this.getCurrentSpeed();
        break;
      case RIGHT:
        this.x += this.getCurrentSpeed();
        break;
      case DOWN:
        this.y -= this.getCurrentSpeed();
        break;
      case LEFT:
        this.x -= this.getCurrentSpeed();
        break;
    }
  };

  public void turnLeft() {
    this.direction = this.direction.getPrevious();
  };

  public void turnRight() {
    this.direction = this.direction.getNext();
  };

  // TODO fix this method according to lab pm
  public void gas(final double amount) {
    incrementSpeed(amount);
  }

  // TODO fix this method according to lab pm
  public void brake(final double amount) {
    decrementSpeed(amount);
  }
}
