package lab2.vehicles;

import java.awt.Color;

/** The Saab 95. */
public class Saab95 extends Car {

  private boolean turboOn;

  /** Empty constructor for Saab 95. */
  public Saab95() {
    super(2, Color.red, 125, "Saab95");
    turboOn = false;
    stopEngine();
  }

  /** Activates the turbo unit. */
  public void setTurboOn() {
    turboOn = true;
  }

  /** Deactivets the turbo unit. */
  public void setTurboOff() {
    turboOn = false;
  }

  /**
   * Returns the car's speed factor.
   *
   * @return Speed factor.
   */
  @Override
  protected double speedFactor() {
    double turbo = 1;
    if (turboOn) {
      turbo = 1.3;
    }

    return getEnginePower() * 0.01 * turbo;
  }

  /**
   * Returns true if turbo is on, false if it is off.
   *
   * @return Turbo is on
   */
  public boolean isTurboOn() {
    return this.turboOn;
  }
}
