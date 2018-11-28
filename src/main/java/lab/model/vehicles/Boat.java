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
   */
  public Boat(final Color color, final double enginePower, final String modelName) {
    super(color, enginePower, modelName);
  }
}
