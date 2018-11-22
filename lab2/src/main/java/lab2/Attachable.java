package lab2;

public interface Attachable {
  /**
   * Attaches to the given object.
   *
   * @param attacher The object to attach to.
   */
  public void attachTo(final Truck attachable);

  /** Detaches the attachable. */
  public void detach();

  /** Any procedures to perform before any movement is issued. */
  public void safetyProcedures();

  /**
   * Returns true if attached to anything, otherwise false. @return True if attached to anything,
   * otherwise false.
   */
  public boolean isAttached();
}
