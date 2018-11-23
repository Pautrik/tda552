package lab2;

/** A ramp which can be lowered or raised. */
public class Ramp {
  /** Lowest angle for the ramp. */
  private final double minAngle;

  /** Highest angle for the ramp. */
  private final double maxAngle;

  /** The ramps current angle. */
  private double angle;

  /**
   * Ramp constructor.
   *
   * @param minAngle The minimum angle of the ramp.
   * @param maxAngle The maximum angle of the ramp.
   */
  public Ramp(final double minAngle, final double maxAngle) {
    this.minAngle = minAngle;
    this.maxAngle = maxAngle;
  }

  /**
   * Returns the current angle.
   *
   * @return Ramp angle
   */
  public double getAngle() {
    return this.angle;
  }

  /**
   * Tries to raise ramp with the parameter degrees. The new platform angle value will never exceed
   * MAX_ANGLE.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to raise the ramp. May be negative.
   */
  public void raise(final double degrees) {
    final double potentialNewAngle = this.angle + degrees;

    if (potentialNewAngle < this.minAngle) {
      this.angle = this.minAngle;
    } else if (potentialNewAngle > this.maxAngle) {
      this.angle = this.maxAngle;
    } else {
      this.angle = potentialNewAngle;
    }
  }

  /**
   * Tries to lower ramp with the parameter degrees The new platform angle value will never be less
   * than MIN_ANGLE.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to lower the ramp. May be negative.
   */
  public void lower(final double degrees) {
    raise(-degrees);
  }

  /** Closes the ramp. */
  public void close() {
    this.angle = this.minAngle;
  }
}
