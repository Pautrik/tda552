package lab2;

public interface Attachable {
  /**
   * Attaches to the given object.
   *
   * @param attacher The object to attach to.
   */
  public void attachTo(final Truck attacher);

  /** Detaches the attachable. */
  public void detach();

  /** Any procedures to perform before any movement is issued. */
  public void safetyProcedures();
}
