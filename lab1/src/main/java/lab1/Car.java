package lab1;

import java.awt.Color;


/** A movable car. */
public abstract class Car implements Movable {
  Color color;
  double currentSpeed;
  double enginePower;
  String modelName;
  int numberOfDoors = 4;
  int x;
  int y;
  Direction direction = Direction.UP;

  /** The car's current direction. */
  public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    /**
     * Returns the next direction, going in a clockwise manner.
     *
     * @return Next direction, going in a clockwise manner.
     */
    Direction getNext() {
      return values()[(ordinal() + 1) % values().length];
    }

    /**
     * Returns the previous direction, going in a counter clockwise manner.
     *
     * @return Previous direction, going in a counter clockwise manner.
     */
    Direction getPrevious() {
      return this.ordinal() > 0 ? values()[this.ordinal() - 1] : values()[values().length - 1];
    }
  }

  /**
   * Returns the amount of doors.
   *
   * @return Number of doors.
   */
  int getNumberOfDoors() {
    return numberOfDoors;
  }

  /**
   * Returns the engine power.
   *
   * @return Engine power.
   */
  double getEnginePower() {
    return enginePower;
  }

  /**
   * Returns the current speed.
   *
   * @return Current speed.
   */
  double getCurrentSpeed() {
    return currentSpeed;
  }

  /**
   * Returns the color of the car.
   *
   * @return Color of the car.
   */
  Color getColor() {
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

  /** Starts the engine. */
  void startEngine() {
    currentSpeed = 0.1;
  }

  /** Stops the engine. */
  void stopEngine() {
    currentSpeed = 0;
  }

  /**
   * Increments the car's speed, taking each car's speed factor into account.
   *
   * @param amount The speed to increase multiplied by the car's speed factor.
   */
  void incrementSpeed(final double amount) throws IllegalArgumentException {
    double potentialNewSpeed = getCurrentSpeed() + speedFactor() * amount;

    if (potentialNewSpeed > enginePower) {
      throw new IllegalArgumentException("Speed may not exceed engine power");
    }

    currentSpeed = potentialNewSpeed;
  }

  /**
   * Decrements the car's speed, taking each car's speed factor into account.
   *
   * @param amount The speed to decrese multiplied by the car's speed factor.
   */
  void decrementSpeed(final double amount) {
    currentSpeed = getCurrentSpeed() - speedFactor() * amount;
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
  int getX() {
    return x;
  }

  /**
   * Returns the current Y position.
   *
   * @return Current Y position.
   */
  int getY() {
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
  }

  /**
   * Turns the car left.
   *
   * @see Direction::getPrevious
   */
  public void turnLeft() {
    this.direction = this.direction.getPrevious();
  }

  /**
   * Turns the car right.
   *
   * @see Direction::getNext
   */
  public void turnRight() {
    this.direction = this.direction.getNext();
  }

  /**
   * Accelerates the car.
   *
   * @param amount Amount of acceleration being applied, must be greater or equal to 0 and less or
   *     equal to 1.
   * @throws IllegalArgumentException If a negative amount is applied
   * @throws IllegalArgumentException If an amount greater than 1 is applied
   * @see break
   */
  void gas(final double amount) throws IllegalArgumentException {
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
   *
   */
  void brake(final double amount) {
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
