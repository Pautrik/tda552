package lab2;

import java.awt.*;

/** Scania truck. */
public class Scania extends Car {

  /** Lowest angle for the trucks platform. */
  private static final double MIN_ANGLE = 0;

  /** Highest angle for the trucks platform. */
  private static final double MAX_ANGLE = 70;

  /** The platforms current angle. */
  private double platformAngle;

  /** Empty constructor for Scania. */
  public Scania() {
    super(2, Color.blue, 730, "Scania");

    this.platformAngle = MIN_ANGLE;
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

  /**
   * Returns the platforms current angle.
   *
   * @return Platform angle
   */
  public double getPlatformAngle() {
    return this.platformAngle;
  }

  /**
   * Tries to raise platform with the parameter degrees. The new platform angle value will never
   * exceed MAX_ANGLE. The truck will stop before the platform is raised.
   *
   * @see MIN_ANGLE
   * @see MAX_ANGLE
   * @param degrees Degrees to raise the platform. May be negative.
   */
  public void raisePlatform(final double degrees) {
    this.stopEngine();

    final double potentialNewAngle = this.platformAngle + degrees;

    if (potentialNewAngle < MIN_ANGLE) {
      this.platformAngle = MIN_ANGLE;
    } else if (potentialNewAngle > MAX_ANGLE) {
      this.platformAngle = MAX_ANGLE;
    } else {
      this.platformAngle = potentialNewAngle;
    }
  }

  /**
   * Tries to lower platform with the parameter degrees The new platform angle value will never be
   * less than MIN_ANGLE. The truck will stop before the platform is lowered.
   *
   * @see MIN_ANGLE
   * @see MAX_ANGLE
   * @param degrees Degrees to lower the platform. May be negative.
   */
  public void lowerPlatform(final double degrees) {
    raisePlatform(-degrees);
  }

  /** Moves the truck in the current direction. Platform angle is reset before moving. */
  @Override
  public void move() {
    platformAngle = MIN_ANGLE;
    super.move();
  }

  /**
   * {@inheritDoc}
   *
   * Platform angle is reset before turning.
   */
  @Override
  public void turnLeft() {
    platformAngle = MIN_ANGLE;
    super.turnLeft();
  }

  /**
   * {@inheritDoc}
   *
   * Platform angle is reset before turning.
   */
  @Override
  public void turnRight() {
    platformAngle = MIN_ANGLE;
    super.turnRight();
  }
}
