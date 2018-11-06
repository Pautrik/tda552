package lab1;

import java.awt.Color;

/** A movable car. */
public abstract class Car implements Movable {
  protected Color color;
  protected double currentSpeed;
  protected double enginePower;
  protected String modelName;
  protected int numberOfDoors = 4;
  protected int x;
  protected int y;
  protected Direction direction = Direction.UP;

  /** The car's current direction. */
  public enum Direction {
    UP,
    RIGHT,
    LEFT,
    DOWN;

    /**
     * Returns the next direction, going in a clockwise manner.
     *
     * @return Next direction, going in a clockwise manner.
     */
    public Direction getNext() {
      return values()[(ordinal() + 1) % values().length];
    }

    /**
     * Returns the previous direction, going in a counter clockwise manner.
     *
     * @return Previous direction, going in a counter clockwise manner.
     */
    public Direction getPrevious() {
      return values()[(ordinal() - 1) % values().length];
    }
  };

  /**
   * Returns the amount of doors.
   *
   * @return Number of doors.
   */
  public int getNumberOfDoors() {
    return numberOfDoors;
  }

  /**
   * Returns the engine power.
   *
   * @return Engine power.
   */
  public double getEnginePower() {
    return enginePower;
  }

  /**
   * Returns the current speed.
   *
   * @return Current speed.
   */
  public double getCurrentSpeed() {
    return currentSpeed;
  }

  /**
   * Returns the color of the car.
   *
   * @return Color of the car.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Sets the color of the car.
   *
   * @param color The new color of the car.
   */
  public void setColor(final Color color) {
    this.color = color;
  }

  /** Starts the engine. */
  public void startEngine() {
    currentSpeed = 0.1;
  }

  /** Stops the engine. */
  public void stopEngine() {
    currentSpeed = 0;
  }

  /**
   * Increments the car's speed, taking each car's speed factor into account.
   *
   * @param amount The speed to increase multiplied by the car's speed factor.
   */
  public void incrementSpeed(final double amount) {
    currentSpeed = getCurrentSpeed() + speedFactor() * amount;
  }

  /**
   * Decrements the car's speed, taking each car's speed factor into account.
   *
   * @param amount The speed to decrese multiplied by the car's speed factor.
   */
  public void decrementSpeed(final double amount) {
    currentSpeed = getCurrentSpeed() - speedFactor() * amount;
  }

  /**
   * Returns the car's speed factor.
   *
   * @return Speed factor.
   */
  public abstract double speedFactor();

  /**
   * Returns the current X position.
   *
   * @return Current X position.
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the current Y position.
   *
   * @return Current Y position.
   */
  public int getY() {
    return y;
  }

  /** Moves the car in the current direction. */
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

  /**
   * Turns the car left.
   *
   * @see Direction::getPrevious
   */
  public void turnLeft() {
    this.direction = this.direction.getPrevious();
  };

  /**
   * Turns the car right.
   *
   * @see Direction::getNext
   */
  public void turnRight() {
    this.direction = this.direction.getNext();
  };

  /** @todo Implement according to lab PM. */
  public void gas(final double amount) {
    incrementSpeed(amount);
  }

  /** @todo Implement according to lab PM. */
  public void brake(final double amount) {
    decrementSpeed(amount);
  }
}
