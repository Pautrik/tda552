package src.main.java.lab1;

import java.awt.Color;

/** The Volvo 240. */
public class Volvo240 extends Car {

  private static final double TRIM_FACTOR = 1.25;

  public Volvo240() {
    color = Color.black;
    enginePower = 100;
    modelName = "Volvo240";
    stopEngine();
  }

  public double speedFactor() {
    return enginePower * 0.01 * TRIM_FACTOR;
  }
}
