package lab.model;

/** Allows transportation. */
public interface Transportable {

  /** Sets the transporter. */
  public void setTransporter(Positionable transporter);

  /** Unsets the transporter. */
  public void resetTransporter();

  /**
   * Returns true if the object is being transported, otherwise false.
   *
   * @return True if the object is being transported, otherwise false
   */
  public boolean isBeingTransported();
}
