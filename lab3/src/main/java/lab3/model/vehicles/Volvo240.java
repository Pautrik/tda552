package lab3.model.vehicles;

import java.awt.Color;

/** The Volvo 240. */
public class Volvo240 extends Car {

  /** Trim factor. */
  private static final double TRIM_FACTOR = 1.25;

  /** Empty constructor for Volvo 240. */
  public Volvo240() {
    super(4, Color.black, 100, "Volvo240");
    stopEngine();
  }

  /**
   * Returns the car's speed factor.
   *
   * @return Speed factor.
   */
  @Override
  protected double speedFactor() {
    return getEnginePower() * 0.01 * TRIM_FACTOR;
  }
}
