package lab.model.vehicles;

import java.awt.Color;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import lab.model.Ramp;
import lab.model.Storing;

/** A cargo boat with loading capabilities. */
public class CargoBoat extends Boat implements Storing<Car> {

  /** Lowest angle for the trailer's ramp. */
  private static final double MIN_ANGLE = 0;

  /** Highest angle for the trailer's ramp. */
  private static final double MAX_ANGLE = 70;

  /** The trailer's ramp. */
  private final Ramp ramp;

  /** The storage. */
  private final LinkedList<Car> storage;

  /** Size of storage. */
  private final int storageSize;

  /**
   * Cargo Boat constructor.
   *
   * @param storageSize how many items can you fit in the cargo-hold?
   * @param color paint job.
   * @param enginePower power of the spicy engine.
   * @param modelName name of the Boat model.
   * @param x start position
   * @param y start position
   */
  public CargoBoat(
      final int storageSize,
      final Color color,
      final double enginePower,
      final String modelName,
      final int x,
      final int y) {
    super(color, enginePower, modelName, x, y);

    this.storage = new LinkedList<Car>();
    this.ramp = new Ramp(MIN_ANGLE, MAX_ANGLE);
    this.storageSize = storageSize;
  }

  /**
   * Adds an car to the storage.
   *
   * @todo Check car position before loading
   * @todo Check if storage is full before adding?
   * @param car The car to add to the storage.
   */
  @Override
  public void load(final Car car) {
    if (this.storage.size() + 1 > this.storageSize) {
      throw new IndexOutOfBoundsException(
          "Trying to load beyond storage size, unload cars to free up space");
    }

    if (Math.abs(car.getX() - this.getX()) > 1 || (car.getY() - this.getY()) > 1) {
      throw new IllegalArgumentException(
          "The loaded car must be in proximity to the trailer before loading");
    }

    this.lowerRamp();
    this.storage.addLast(car);

    car.setTransporter(this);
  }

  /**
   * Unloads an car from the storage, if any cars are loaded. Lowers the ramp if it is raised.
   * Returns any car that is unloaded, otherwise null.
   *
   * @return The unloaded car if any, otherwise null
   */
  @Override
  public Car unload() {
    this.lowerRamp();

    if (this.hasObjects()) {
      final Car lastLoadedObject = this.storage.removeFirst();
      lastLoadedObject.resetTransporter();

      return lastLoadedObject;
    }

    return null;
  }

  /**
   * Returns true if any objects are loaded.
   *
   * @return True if any objects are loaded, otherwise false
   */
  @Override
  public boolean hasObjects() {
    return !this.storage.isEmpty();
  }

  /**
   * Returns true if storage is empty, otherwise false.
   *
   * @return True if storage is empty, otherwise false
   */
  @Override
  public boolean isEmpty() {
    return this.storage.isEmpty();
  }

  /**
   * Returns true if storage is full, otherwise false.
   *
   * @return True if storage is full, otherwise false
   */
  @Override
  public boolean isFull() {
    return this.storage.size() == this.storageSize;
  }

  /**
   * Returns the vehicle's speed factor.
   *
   * @return Speed factor.
   */
  @Override
  public double speedFactor() {
    return 1;
  }

  /**
   * Returns the currently loaded objects as an immutable list.
   *
   * @return The currently loaded objects as an immutable list
   */
  @Override
  public List<Car> getObjectsAsUnmodifiableList() {
    return Collections.unmodifiableList(this.storage);
  }

  /** Raises the ramp. */
  public void raiseRamp() {
    this.ramp.raise(MAX_ANGLE);
  }

  /** Lowers the ramp. */
  public void lowerRamp() {
    this.ramp.lower(MAX_ANGLE);
  }
}
