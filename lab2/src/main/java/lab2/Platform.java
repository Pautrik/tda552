package lab2;

public class Platform {
  /** Lowest angle for the platform. */
  private final double minAngle;

  /** Highest angle for the platform. */
  private final double maxAngle;

  /** The platforms current angle. */
  private double angle;

  /**
   * Platform constructor.
   *
   * @param minAngle The minimum angle of the platform.
   * @param maxAngle The maximum angle of the platform.
   */
  public Platform(final double minAngle, final double maxAngle) {
    this.minAngle = minAngle;
    this.maxAngle = maxAngle;
  }

  /**
   * Returns the current angle.
   *
   * @return Platform angle
   */
  public double getAngle() {
    return this.angle;
  }

  /**
   * Tries to raise platform with the parameter degrees. The new platform angle value will never
   * exceed MAX_ANGLE.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to raise the platform. May be negative.
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
   * Tries to lower platform with the parameter degrees The new platform angle value will never be
   * less than MIN_ANGLE.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to lower the platform. May be negative.
   */
  public void lower(final double degrees) {
    raise(-degrees);
  }

  /** Closes the platform. */
  public void close() {
    this.angle = this.minAngle;
  }
}
