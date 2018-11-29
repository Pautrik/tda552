package lab.model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import lab.model.vehicles.Truck;

/** A truck trailer with a generic container. */
public class Trailer<T extends Movable & Positionable & Transportable>
    implements Attachable<Truck>, Storing<T>, Positionable {
  private int x;
  private int y;

  /** Lowest angle for the trailer's ramp. */
  private static final double MIN_ANGLE = 0;

  /** Highest angle for the trailer's ramp. */
  private static final double MAX_ANGLE = 70;

  /** The trailer's ramp. */
  private final Ramp ramp;

  /** The truck the trailer is attached to. */
  private Truck truck;

  /** The storage. */
  private final LinkedList<T> storage;

  /** Size of storage. */
  private final int storageSize;

  /**
   * Empty constructor for Trailer which stores items of type T.
   *
   * @param storageSize the number of slots in the storage.
   */
  public Trailer(final int storageSize) {
    this.storage = new LinkedList<T>();
    this.ramp = new Ramp(MIN_ANGLE, MAX_ANGLE);
    this.storageSize = storageSize;
  }

  /**
   * Adds an object to the storage.
   *
   * @todo Check object position before loading
   * @param object The object to add to the storage.
   * @throws IllegalArgumentException If the loaded object is too large to be loaded
   */
  @Override
  public void load(final T object) {
    if (object instanceof Truck) {
      throw new IllegalArgumentException("Trucks are too large to be loaded onto the trailer");
    }

    if (Math.abs(object.getPosition().getX() - this.x) > 1
        || (object.getPosition().getY() - this.getY()) > 1) {
      throw new IllegalArgumentException(
          "The loaded object must be in proximity to the trailer before loading");
    }

    if (this.storage.size() + 1 > this.storageSize) {
      throw new IndexOutOfBoundsException(
          "Trying to load beyond storage size, unload objects to free up space");
    }

    this.lowerRamp();
    this.storage.add(object);

    object.setTransporter(this);
  }

  /**
   * {@inheritDoc}
   *
   * @todo Set the objects position from the trailer.
   */
  @Override
  public T unload() {
    this.lowerRamp();

    if (this.hasObjects()) {
      final T lastLoadedObject = this.storage.removeLast();
      lastLoadedObject.resetTransporter();

      return lastLoadedObject;
    }

    return null;
  }

  /** Raises the ramp. */
  public void raiseRamp() {
    if (this.truck instanceof Truck) {
      this.truck.stopEngine();
    }

    this.ramp.raise(MAX_ANGLE);
  }

  /** Lowers the ramp. */
  public void lowerRamp() {
    if (this.truck instanceof Truck) {
      this.truck.stopEngine();
    }

    this.ramp.raise(-MAX_ANGLE);
  }

  /**
   * Returns the current ramp angle.
   *
   * @return The current ramp angle
   */
  public double getRampAngle() {
    return this.ramp.getAngle();
  }

  /**
   * Attaches the trailer to the given truck.
   *
   * @param truck The truck to attach to
   */
  @Override
  public void attachTo(final Truck truck) {
    this.detach();

    this.truck = truck;
    this.truck.setAttachment(this);
  }

  /** Detaches the trailer if attached to a truck. */
  @Override
  public void detach() {
    if (this.truck instanceof Truck) {
      this.x = this.truck.getX();
      this.y = this.truck.getY();

      this.truck = null;
    }
  }

  /** Closes the ramp before the truck is allowed to move. */
  @Override
  public void safetyProcedures() {
    this.ramp.close();
  }

  /**
   * Returns the current X position. Returns the trucks' position if attached.
   *
   * @return Current X position.
   */
  public int getX() {
    if (this.truck instanceof Truck) {
      return this.truck.getX();
    }

    return x;
  }

  /**
   * Returns the current Y position. Returns the trucks' position if attached.
   *
   * @return Current Y position.
   */
  public int getY() {
    if (this.truck instanceof Truck) {
      return this.truck.getY();
    }

    return y;
  }

  /**
   * Returns the currently loaded objects as an immutable list.
   *
   * @return The currently loaded objects as an immutable list
   */
  @Override
  public List<T> getObjectsAsUnmodifiableList() {
    return Collections.unmodifiableList(this.storage);
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
   * Returns true if an attachment is attached, false if not
   *
   * @return True if an attachment is attached, false if not
   */
  @Override
  public boolean isAttached() {
    return this.truck instanceof Truck;
  }

  /**
   * Returns the current position of the vehicle in the form of a Point.
   *
   * @return Current position in the form of a Point
   */
  @Override
  public Point2D getPosition() {
    if (this.truck instanceof Truck) {
      return this.truck.getPosition();
    }

    return new Point(x, y);
  }
}
