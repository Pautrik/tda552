package lab.model.vehicles;

import java.awt.*;
import lab.model.*;

/** A generic vehicle with an engine */
public abstract class Vehicle implements Movable, Turnable, Positionable, Transportable {
  private double currentSpeed;
  private Direction direction = Direction.UP;

  private Point point;
  protected Color color;
  protected final double enginePower;
  private final String modelName;
  private State state;

  private Positionable transportedBy;

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
    this.point = new Point();
  }

  /**
   * Returns the current position of the vehicle in the form of a Point.
   *
   * @return Current position in the form of a Point
   */
  @Override
  public Point getPosition() {
    return point;
  }

  /** State of the car to enable checks for changes in movement or transport etc. */
  public enum State {
    RUNNING,
    PARKED,
    BEING_TRANSPORTED;
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

  /** Starts the engine if vehicle is in working order and not being transported. */
  public void startEngine() {
    if (this.state == State.BEING_TRANSPORTED) {
      throw new IllegalStateException("Vehicle can not be started while being transported.");
    }

    if (this.state == State.PARKED) {
      currentSpeed = 0.1;
    }

    this.state = State.RUNNING;
  }

  /** Stops the engine if the car is running. */
  public void stopEngine() {
    if (this.state != State.RUNNING) {
      return;
    }

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
    if (this.state == State.BEING_TRANSPORTED) {
      return (int) this.transportedBy.getPosition().getX();
    }

    return point.x;
  }

  /**
   * Returns the current Y position.
   *
   * @return Current Y position.
   */
  public int getY() {
    if (this.state == State.BEING_TRANSPORTED) {
      return (int) this.transportedBy.getPosition().getY();
    }
    return point.y;
  }

  /** Moves the vehicle in the current direction, if state allows moving. */
  public void move() {
    if (this.state != State.RUNNING) {
      return;
    }

    switch (this.direction) {
      case UP:
        this.point.y += this.getCurrentSpeed();
        break;
      case RIGHT:
        this.point.x += this.getCurrentSpeed();
        break;
      case DOWN:
        this.point.y -= this.getCurrentSpeed();
        break;
      case LEFT:
        this.point.x -= this.getCurrentSpeed();
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
   * Accelerates the vehicle. Does not do anything if state disallows applying gas (i.e. in case it
   * is not running.
   *
   * @param amount Amount of acceleration being applied, must be greater or equal to 0 and less or
   *     equal to 1.
   * @throws IllegalArgumentException If a negative amount is applied
   * @throws IllegalArgumentException If an amount greater than 1 is applied
   * @see break
   */
  public void gas(final double amount) throws IllegalArgumentException {
    if (this.state != State.RUNNING) {
      return;
    }

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
   * Decelerates the vehicle. Does not do anything if state disallows braking (i.e. in case it is
   * not running.
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
    if (this.state != State.RUNNING) {
      return;
    }

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
   *
   * @throws IllegalStateException If states dissallows pushing, e.g. it is being transported.
   */
  public void pushInDirection(final Direction direction) throws IllegalStateException {
    if (this.state == State.BEING_TRANSPORTED) {
      throw new IllegalStateException("Vehicle can not be pushed while being transported.");
    }

    switch (this.direction) {
      case UP:
        this.point.y += 1;
        break;
      case RIGHT:
        this.point.x += 1;
        break;
      case DOWN:
        this.point.y -= 1;
        break;
      case LEFT:
        this.point.x -= 1;
        break;
    }
  }

  /**
   * Sets the transporter. The position of the vehicle should reflect that of the transporter.
   *
   * @see resetTransport
   */
  public void setTransporter(final Positionable transporter) {
    this.transportedBy = transporter;
    this.state = State.BEING_TRANSPORTED;
  }

  /**
   * Unsets the transporter.
   *
   * @see setTransporter
   * @todo Should the push behavior instead be called by the transporter?
   */
  public void resetTransporter() {
    this.state = State.PARKED;
    this.point.x = (int) this.transportedBy.getPosition().getX();
    this.point.y = (int) this.transportedBy.getPosition().getY();

    this.transportedBy = null;

    this.pushInDirection(Direction.UP);
  }

  /**
   * Returns true if the object is being transported, otherwise false.
   *
   * @return True if the object is being transported, otherwise false
   */
  public boolean isBeingTransported() {
    return this.state == State.BEING_TRANSPORTED;
  }

  /**
   * Returns the model name.
   *
   * @return name of vehicle.
   */
  public String getModelName() {
    return modelName;
  }
}
