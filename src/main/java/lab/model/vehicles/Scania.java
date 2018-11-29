package lab.model.vehicles;

import java.awt.Color;

/** Scania truck. */
public class Scania extends Truck {
  protected static final String IMAGE_PATH = "./src/main/java/lab/res/pics/Scania.jpg";

  /** Constructor for Scania. */
  public Scania() {
    super(2, Color.blue, 730, "Scania");
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
