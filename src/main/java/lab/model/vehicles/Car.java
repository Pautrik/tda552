package lab.model.vehicles;

import java.awt.Color;

/** A movable car. */
public abstract class Car extends Vehicle {
  private int numberOfDoors = 4;

  /**
   * Car constructor.
   *
   * @param numberOfDoors how many ways can you entire the car?
   * @param color paint job.
   * @param enginePower power of the spicy engine.
   * @param modelName name of the Vehicle model.
   * @param x start position
   * @param y start position
   */
  public Car(
      final int numberOfDoors,
      final Color color,
      final double enginePower,
      final String modelName,
      final int x,
      final int y) {
    super(color, enginePower, modelName, x, y);
    this.numberOfDoors = numberOfDoors;
  }

  /**
   * Returns the amount of doors.
   *
   * @return Number of doors.
   */
  public int getNumberOfDoors() {
    return numberOfDoors;
  }
}
