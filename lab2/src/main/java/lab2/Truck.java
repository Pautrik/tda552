package lab2;

import java.awt.Color;

/** A truck. */
public abstract class Truck extends Car {

  /** An attachable, e.g. a trailer. */
  private Attachable attachment;

  /** Empty constructor for Truck. */
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
    if (this.attachment instanceof Attachable) {
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
    if (this.attachment instanceof Attachable) {
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
    if (this.attachment instanceof Attachable) {
      this.attachment.safetyProcedures();
    }
    super.turnRight();
  }

  /** Returns any attachment. */
  public Attachable getAttachment() {
    return this.attachment;
  }

  /** Attaches an attachment. Detaches from any previous attachment before re-attaching. */
  public void setAttachment(final Attachable attachment) {
    attachment.detach();

    this.attachment = attachment;
  }

  /** Removes an attachment. */
  public void detachAttachment() {
    if (this.attachment instanceof Attachable) {
      this.attachment = attachment;
    }
  }
}
