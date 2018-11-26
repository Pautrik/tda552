package vehicles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lab2.Direction;
import lab2.Movable;
import lab2.Ramp;
import lab2.Storing;

/** A cargo boat with loading capabilities. */
public class CargoBoat extends Boat implements Storing<Car> {

  /** Lowest angle for the trailer's ramp. */
  private static final double MIN_ANGLE = 0;

  /** Highest angle for the trailer's ramp. */
  private static final double MAX_ANGLE = 70;

  /** The trailer's ramp. */
  private final Ramp ramp;

  /** The storage. */
  private final List<Car> storage;

  /** Size of storage. */
  private int storageSize;

  /** Cargo Boat constructor.
   *
   * @param storageSize how many items can you fit in the cargo-hold?
   * @param color paint job.
   * @param enginePower power of the spicy engine.
   * @param modelName name of the Boat model.
   */
  public CargoBoat(
      final int storageSize, final Color color, final double enginePower, final String modelName) {
    super(color, enginePower, modelName);

    this.storage = new ArrayList<Car>(storageSize);
    this.ramp = new Ramp(MIN_ANGLE, MAX_ANGLE);
    this.storageSize = storageSize;
  }

  /**
   * Adds an object to the storage.
   *
   * @todo Check object position before loading
   * @todo Check if storage is full before adding?
   * @param object The object to add to the storage.
   */
  public void load(final Car object) {
    if (this.storage.size() + 1 > this.storageSize) {
      throw new IndexOutOfBoundsException(
          "Trying to load beyond storage size, Unload objects to free up space");
    }

    if (Math.abs(object.getX() - this.getX()) > 1 || (object.getY() - this.getY()) > 1) {
      throw new IllegalArgumentException(
          "The loaded object must be in proximity to the trailer before loading");
    }

    this.lowerRamp();
    this.storage.add(object);
  }

  /**
   * {@inheritDoc}
   *
   * @todo Set the objects position from the trailer.
   */
  public Car unload() {
    this.lowerRamp();

    if (this.hasObjects()) {
      final Car lastLoadedObject = this.storage.get(this.storage.size() - 1);

      if (!(lastLoadedObject instanceof Movable)) {
        throw new IllegalArgumentException(
            "Loaded object is not movable and can not be unloaded on its own");
      }

      lastLoadedObject.pushInDirection(Direction.UP);

      this.storage.remove(lastLoadedObject);

      return lastLoadedObject;
    }

    return null;
  }

  /**
   * Returns true if any objects are loaded.
   *
   * @return True if any objects are loaded, otherwise false
   */
  public boolean hasObjects() {
    return !this.storage.isEmpty();
  }

  /**
   * Returns true if storage is empty, otherwise false.
   *
   * @return True if storage is empty, otherwise false
   */
  public boolean isEmpty() {
    return this.storage.isEmpty();
  }

  /**
   * Returns true if storage is full, otherwise false.
   *
   * @return True if storage is full, otherwise false
   */
  public boolean isFull() {
    return this.storage.size() == this.storageSize;
  }

  public double speedFactor() {
    return 1;
  }

  /**
   * Returns the currently loaded objects as an immutable list.
   *
   * @return The currently loaded objects as an immutable list
   */
  public List<Car> getObjectsAsUnmodifiableList() {
    return Collections.unmodifiableList(this.storage);
  }

  /** Raises the ramp. */
  public void raiseRamp() {
    this.ramp.raise(MAX_ANGLE);
  }

  /** Lowers the ramp. */
  public void lowerRamp() {
    this.ramp.raise(-MAX_ANGLE);
  }
}
