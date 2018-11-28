package lab.model;

import java.util.List;

/**
 * Handles storing for items of type T.
 *
 * @param <T> generic
 */
public interface Storing<T> {
  /**
   * Adds an object to the storage.
   *
   * @param object The object to add to the storage.
   */
  public void load(final T object);

  /**
   * Unloads an object from the storage, if any objects are loaded. Lowers the ramp if it is raised.
   * Returns any object that is unloaded, otherwise null.
   *
   * @return The unloaded object if any, otherwise null
   */
  public T unload();

  /**
   * Returns true if storage is full, otherwise false.
   *
   * @return True if storage is full, otherwise false
   */
  public boolean isFull();

  /**
   * Returns true if storage is empty, otherwise false.
   *
   * @return True if storage is empty, otherwise false
   */
  public boolean isEmpty();

  /**
   * Returns true if any objects are loaded.
   *
   * @return True if any objects are loaded, otherwise false
   */
  public boolean hasObjects();

  /**
   * Returns the currently loaded objects as an immutable list.
   *
   * @return The currently loaded objects as an immutable list
   */
  public List<T> getObjectsAsUnmodifiableList();
}
