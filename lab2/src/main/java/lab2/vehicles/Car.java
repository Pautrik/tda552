package lab2.vehicles;

import java.awt.Color;

import lab2.Movable;
import lab2.Turnable;
import lab2.Vehicle;
import lab2.Direction;

/** A movable car. */
public abstract class Car extends Vehicle implements Movable, Turnable {
  private int x;
  private int y;
  private double currentSpeed;
  private int numberOfDoors = 4;
  private Direction direction = Direction.UP;

  /** Car constructor. */
  public Car(
      final int numberOfDoors,
      final Color color,
      final double enginePower,
      final String modelName) {
    super(color, enginePower, modelName);
    this.numberOfDoors = numberOfDoors;
  }


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
  void setColor(final Color color) {
    this.color = color;
  }

  /** Starts the engine if Car is in working order. */
  public void startEngine() {
    if (getState() == State.PARKED ) {
        currentSpeed = 0.1;
    }
    runCar();
  }

  /** Stops the engine. */
  public void stopEngine() {
      if (getState() == State.RUNNING)
    currentSpeed = 0;
    parkCar();
  }

  /** Fixes the Car */
  private void runCar() { setState(State.RUNNING); }

  /** Parks the Car */
  private void parkCar() { setState(State.PARKED); }

  /** Breaks the Car */
  private void breakCar() { setState(State.BROKEN); }


  /**
   * Increments the car's speed, taking each car's speed factor into account.
   *
   * @param amount The speed to increase multiplied by the car's speed factor.
   */
  private void incrementSpeed(final double amount) {
    final double potentialNewSpeed = getCurrentSpeed() + speedFactor() * amount;

    if (potentialNewSpeed <= enginePower) {
      currentSpeed = potentialNewSpeed;
    } else {
      currentSpeed = enginePower;
    }
  }

  /**
   * Decrements the car's speed, taking each car's speed factor into account.
   *
   * @param amount The speed to decrese multiplied by the car's speed factor.
   */
  private void decrementSpeed(final double amount) {
    final double potentialNewSpeed = getCurrentSpeed() - speedFactor() * amount;

    if (potentialNewSpeed >= 0) {
      currentSpeed = potentialNewSpeed;
    } else {
      currentSpeed = 0;
    }
  }

  /**
   * Returns the car's speed factor.
   *
   * @return Speed factor.
   */
  protected abstract double speedFactor();

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

  /**
   * Accelerates the car.
   *
   * @param amount Amount of acceleration being applied, must be greater or equal to 0 and less or
   *     equal to 1.
   * @throws IllegalArgumentException If a negative amount is applied
   * @throws IllegalArgumentException If an amount greater than 1 is applied
   * @see break
   */
  public void gas(final double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("Can not gas using a negative amount, use brake instead");
    }

    if (amount > 1) {
      throw new IllegalArgumentException(
          "Maximum amount of gas exceeded, must not be greater than 1");
    }

    incrementSpeed(amount);
  }

  /**
   * Decelerates the car.
   *
   * @param amount Amount of deceleration being applied, must be greater or equal to 0 and less or
   *     equal to 1.
   * @throws IllegalArgumentException If a negative amount is applied
   * @throws IllegalArgumentException If an amount greater than 1 is applied
   * @see gas
   */
  public void brake(final double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("Can not brake using a negative amount, use gas instead");
    }

    if (amount > 1) {
      throw new IllegalArgumentException(
          "Maximum amount of brake exceeded, must not be greater than 1");
    }

    decrementSpeed(amount);
  }
}
