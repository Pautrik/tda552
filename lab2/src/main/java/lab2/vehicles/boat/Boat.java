package lab2.vehicles;

import java.awt.Color;

/** A boat. */
public abstract class Boat extends Vehicle {

  /** Boat constructor. */
  public Boat(final Color color, final double enginePower, final String modelName) {
    super(color, enginePower, modelName);
  }
}
