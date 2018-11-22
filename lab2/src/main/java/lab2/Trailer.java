package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lab2.vehicles.Truck;

/** A truck trailer with a generic container. */
public class Trailer<T> implements Attachable<Truck>, Positionable {
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
  private final List<T> storage;

  /** Empty constructor for Trailer<T>. */
  public Trailer(final int sizeOfStorage) {
    this.storage = new ArrayList<T>(sizeOfStorage);
    this.ramp = new Ramp(MIN_ANGLE, MAX_ANGLE);
  }

  /**
   * Adds an object to the storage.
   *
   * @todo Check object position before loading
   * @todo Check if storage is full before adding?
   * @param object The object to add to the storage.
   */
  public void load(final T object) {
    if (this.isAttached() && this.truck == object) {
      throw new IllegalArgumentException("Trailer can not load the truck it is attached to.");
    }

    this.lowerRamp();
    this.storage.add(object);
  }

  /**
   * Unloads an object from the storage, if any objects are loaded. Lowers the ramp if it is raised.
   *
   * @todo Set the objects position from the trailer.
   */
  public void unload() {
    this.lowerRamp();

    if (this.hasObjects()) {
      final T lastLoadedObject = this.storage.get(this.storage.size() - 1);
      this.storage.remove(lastLoadedObject);
    }
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
  public List<T> getObjectsAsUnmodifiableList() {
    return Collections.unmodifiableList(this.storage);
  }

  /**
   * Returns true if any objects are loaded.
   *
   * @return True if any objects are loaded, otherwise false
   */
  public boolean hasObjects() {
    return this.storage.size() > 0;
  }

  /**
   * Returns true if an attachment is attached, false if not
   *
   * @return True if an attachment is attached, false if not
   */
  public boolean isAttached() {
    return this.truck instanceof Truck;
  }
}
