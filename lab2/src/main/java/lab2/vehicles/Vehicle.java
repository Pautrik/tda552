package lab2.vehicles;

import java.awt.*;
import lab2.Direction;
import lab2.Movable;
import lab2.Positionable;
import lab2.Turnable;

public abstract class Vehicle implements Movable, Turnable, Positionable {
  private int x;
  private int y;
  private double currentSpeed;
  private Direction direction = Direction.UP;

  protected Color color;
  protected final double enginePower;
  private final String modelName;
  private State state;

  /**
   * Vehicle constructor
   *
   * @param color paint job.
   * @param enginePower power of the spicy engine.
   * @param modelName name of the Vehicle model.
   */
  public Vehicle(final Color color, final double enginePower, final String modelName) {
    this.color = color;
    this.enginePower = enginePower;
    this.modelName = modelName;
    this.state = State.PARKED;
  }

  /** State of the car to enable checks for changes in movement or transport etc. */
  public enum State {
    RUNNING,
    PARKED,
    IN_TRANSPORT,
  }

  /**
   * Returns the current state of the vehicle.
   *
   * @return Vehicle state.
   */
  public State getState() {
    return this.state;
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
   * Returns the color of the vehicle.
   *
   * @return Color of the vehicle.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Sets the color of the vehicle.
   *
   * @param color The new color of the vehicle.
   */
  public void setColor(final Color color) {
    this.color = color;
  }

  /** Starts the engine if Vehicle is in working order. */
  public void startEngine() {
    if (getState() == State.PARKED) {
      currentSpeed = 0.1;
    }

    this.state = State.RUNNING;
  }

  /** Stops the engine. */
  public void stopEngine() {
    currentSpeed = 0;
    this.state = State.PARKED;
  }

  /**
   * Increments the vehicle's speed, taking each vehicle's speed factor into account.
   *
   * @param amount The speed to increase multiplied by the vehicle's speed factor.
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
   * Decrements the vehicle's speed, taking each vehicle's speed factor into account.
   *
   * @param amount The speed to decrese multiplied by the vehicle's speed factor.
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
   * Returns the vehicle's speed factor.
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

  /** Moves the vehicle in the current direction. */
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
   * Turns the vehicle left.
   *
   * @see Direction::getPrevious
   */
  public void turnLeft() {
    this.direction = this.direction.getPrevious();
  };

  /**
   * Turns the vehicle right.
   *
   * @see Direction::getNext
   */
  public void turnRight() {
    this.direction = this.direction.getNext();
  };

  /**
   * Accelerates the vehicle.
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
   * Decelerates the vehicle.
   *
   * @param amount Amount of deceleration being applied, must be greater or equal to 0 and less or
   *     equal to 1.
   * @throws IllegalArgumentException If a negative amount is applied
   * @throws IllegalArgumentException If an amount greater than 1 is applied
   * @see gas
   * @todo Boats and airplanes can not brake - they gas() in the other direction. Maybe rename
   *     function?
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

  /**
   * Pushes the vehicle 1 unit in the given direction. @param direction The direction in which to
   * push the vehicle
   */
  public void pushInDirection(Direction direction) {
    switch (this.direction) {
      case UP:
        this.y += 1;
        break;
      case RIGHT:
        this.x += 1;
        break;
      case DOWN:
        this.y -= 1;
        break;
      case LEFT:
        this.x -= 1;
        break;
    }
  }
}
