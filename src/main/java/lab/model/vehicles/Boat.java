package lab.model.vehicles;

import java.awt.Color;

/** A boat. */
public abstract class Boat extends Vehicle {

  /**
   * Boat constructor.
   *
   * @param color paint job.
   * @param enginePower power of the spicy engine.
   * @param modelName name of the Boat model.
   * @param x start position
   * @param y start position
   */
  public Boat(
      final Color color,
      final double enginePower,
      final String modelName,
      final int x,
      final int y) {
    super(color, enginePower, modelName, x, y);
  }
}
