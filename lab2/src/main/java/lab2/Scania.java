package lab2;

import java.awt.*;

/** Scania truck. */
public class Scania extends Car {

  /** Lowest angle for the trucks platform. */
  private final double MIN_ANGLE = 0;

  /** Highest angle for the trucks platform. */
  private final double MAX_ANGLE = 70;

  /** The platforms current angle. */
  private double platformAngle;

  /** Empty constructor for Scania. */
  public Scania() {
    super(2, Color.blue, 730, "Scania");

    this.platformAngle = MIN_ANGLE;
  }


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
   * Tries to raise platform with the parameter degrees
   * @param degrees
   */
  public void raisePlatform(double degrees) {
    double potentialNewAngle = this.platformAngle + degrees;

    if (potentialNewAngle < MIN_ANGLE) {
      this.platformAngle = MIN_ANGLE;
    } else if (potentialNewAngle > MAX_ANGLE) {
      this.platformAngle = MAX_ANGLE;
    } else {
      this.platformAngle = potentialNewAngle;
    }
  }

  /**
   * Tries to lower platform with the parameter degrees
   * @param degrees
   */
  public void lowerPlatform(double degrees) {
    raisePlatform(-degrees);
  }

  @Override
  public void move() {
    platformAngle = MIN_ANGLE;
    super.move();
  }

  @Override
  public void turnLeft() {
    platformAngle = MIN_ANGLE;
    super.turnLeft();
  }

  @Override
  public void turnRight() {
    platformAngle = MIN_ANGLE;
    super.turnRight();
  }
}
