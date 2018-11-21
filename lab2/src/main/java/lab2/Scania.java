package lab2;

import java.awt.*;

public class Scania extends Car {

  private final double MIN_ANGLE = 0;
  private final double MAX_ANGLE = 70;
  private double platformAngle;

  /** Scania constructor. */
  public Scania(int numberOfDoors, Color color, double enginePower, String modelName) {
    super(numberOfDoors, color, enginePower, modelName);

    this.platformAngle = 0.0;
  }

  @Override
  protected double speedFactor() {
    return getEnginePower() * 0.01;
  }

  public double getPlatformAngle() {
    return this.platformAngle;
  }

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
