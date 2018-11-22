package lab2;

import java.awt.Color;

/** A truck. */
public abstract class Truck extends Car {

  /** Lowest angle for the trucks platform. */
  private static final double MIN_ANGLE = 0;

  /** Highest angle for the trucks platform. */
  private static final double MAX_ANGLE = 70;

  /** The truck's platform. */
  private Platform platform;

  /** Empty constructor for Scania. */
  public Truck(
      final int numberOfDoors,
      final Color color,
      final double enginePower,
      final String modelName) {
    super(numberOfDoors, color, enginePower, modelName);

    this.platform = new Platform(MIN_ANGLE, MAX_ANGLE);
  }

  /**
   * Returns the trucks' speed factor.
   *
   * @return Speed factor.
   */
  @Override
  protected double speedFactor() {
    return getEnginePower() * 0.01;
  }

  /** Moves the truck in the current direction. Platform angle is reset before moving. */
  @Override
  public void move() {
    this.platform.close();
    super.move();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Platform angle is reset before turning.
   */
  @Override
  public void turnLeft() {
    this.platform.close();
    super.turnLeft();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Platform angle is reset before turning.
   */
  @Override
  public void turnRight() {
    this.platform.close();
    super.turnRight();
  }

  /**
   * Tries to raise platform with the parameter degrees. The new platform angle value will never
   * exceed MAX_ANGLE. The truck will stop before the platform is raised.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to raise trucks' the platform. May be negative.
   */
  public void raisePlatform(final double degrees) {
    this.stopEngine();
    this.platform.raise(degrees);
  }

  /**
   * Tries to lower platform with the parameter degrees The new platform angle value will never be
   * less than MIN_ANGLE. The truck will stop before the platform is lowered.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to lower the trucks' platform. May be negative.
   */
  public void lowerPlatform(final double degrees) {
    this.stopEngine();
    this.platform.lower(degrees);
  }
}
