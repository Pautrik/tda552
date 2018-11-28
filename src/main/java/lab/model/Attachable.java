package lab.model;

/**
 * Generic attachable that can attach to type T.
 *
 * @param <T> generic
 */
public interface Attachable<T> {
  /**
   * Attaches to the given object.
   *
   * @param attacher The object to attach to.
   */
  public void attachTo(final T attacher);

  /** Detaches the attachable. */
  public void detach();

  /** Any procedures to perform before any movement is issued. */
  public void safetyProcedures();

  /**
   * Returns true if attached to anything, otherwise false. @return True if attached to anything,
   * otherwise false.
   *
   * @return boolean.
   */
  public boolean isAttached();
}
