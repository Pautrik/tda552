package lab.model.vehicles;

import java.awt.Color;

/** The Volvo 240. */
public class Volvo240 extends Car {
  /** Trim factor. */
  private static final double TRIM_FACTOR = 1.25;

  /** Empty constructor for Volvo 240. */
  public Volvo240(final int x, final int y) {
    super(4, Color.black, 100, "Volvo240", x, y);
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

  /**
   * Returns the path to the image.
   *
   * @return The path to the image
   */
  @Override
  protected String getImageFilePath() {
    return "./src/main/java/lab/res/pics/Volvo240.jpg";
  }
}
