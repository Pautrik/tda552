package lab2.vehicles;

import java.awt.Color;
import lab2.Attachable;

/** A truck. */
public abstract class Truck extends Car {

  /** An attachable, e.g. a trailer. */
  private Attachable attachment;

  /**
   * Empty constructor for Truck.
   *
   * @param numberOfDoors how many ways can you entire the car?
   * @param color paint job.
   * @param enginePower power of the spicy engine.
   * @param modelName name of the Vehicle model.
   */
  public Truck(
      final int numberOfDoors,
      final Color color,
      final double enginePower,
      final String modelName) {
    super(numberOfDoors, color, enginePower, modelName);
  }

  /**
   * Returns the trucks' speed factor.
   *
   * @return Speed factor.
   */
  @Override
  protected double speedFactor() {
    return getEnginePower() * 0.01;
  }

  /**
   * Moves the truck in the current direction. Safety procedures are performed on any attachment
   * before moving.
   */
  @Override
  public void move() {
    if (this.hasAttachment()) {
      this.attachment.safetyProcedures();
    }
    super.move();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Safety procedures are performed on any attachment before moving.
   */
  @Override
  public void turnLeft() {
    if (this.hasAttachment()) {
      this.attachment.safetyProcedures();
    }
    super.turnLeft();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Safety procedures are performed on any attachment before moving.
   */
  @Override
  public void turnRight() {
    if (this.hasAttachment()) {
      this.attachment.safetyProcedures();
    }
    super.turnRight();
  }

  /**
   * Returns true if an attachment is attached, false if not
   *
   * @return True if an attachment is attached, false if not
   */
  public boolean hasAttachment() {
    return this.attachment instanceof Attachable;
  }

  /**
   * Attachs an attachment.
   *
   * @param attachable The attachment to attach
   */
  public void setAttachment(final Attachable attachable) {
    this.attachment = attachable;
  }

  /**
   * Returns the attached attachable, if any.
   *
   * @return The attached attachable, if any
   */
  public Attachable getAttachment() {
    return this.attachment;
  }
}
