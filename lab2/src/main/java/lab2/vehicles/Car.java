package lab2.vehicles;

import java.awt.Color;

/** A movable car. */
public abstract class Car extends Vehicle {
  private int numberOfDoors = 4;

  /** Car constructor.
   *
   * @param numberOfDoors how many ways can you entire the car?
   * @param color paint job.
   * @param enginePower power of the spicy engine.
   * @param modelName name of the Vehicle model.
   */
  public Car(
      final int numberOfDoors,
      final Color color,
      final double enginePower,
      final String modelName) {
    super(color, enginePower, modelName);
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
