package lab.model.vehicles;

import java.awt.Color;

/** Scania truck. */
public class Scania extends Truck {

  /** Constructor for Scania. */
  public Scania(final int x, final int y) {
    super(2, Color.blue, 730, "Scania", x, y);
  }

  /**
   * Returns the path to the image.
   *
   * @return The path to the image
   */
  @Override
  protected String getImageFilePath() {
    return "./src/main/java/lab/res/pics/Scania.jpg";
  }
}
