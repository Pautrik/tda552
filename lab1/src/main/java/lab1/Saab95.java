package src.main.java.lab1;

import java.awt.Color;

/** The Saab 95. */
public class Saab95 extends Car {

  private boolean turboOn;

  public Saab95() {
    numberOfDoors = 2;
    color = Color.red;
    enginePower = 125;
    turboOn = false;
    modelName = "Saab95";
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

  public double speedFactor() {
    double turbo = 1;
    if (turboOn) {
      turbo = 1.3;
    }

    return enginePower * 0.01 * turbo;
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
