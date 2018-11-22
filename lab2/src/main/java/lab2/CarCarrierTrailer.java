package lab2;

import java.util.List;

/** A car carrier trailer for trucks. */
public class CarCarrierTrailer implements Attachable, Positionable {
  private int x;
  private int y;

  /** Lowest angle for the trucks platform. */
  private static final double MIN_ANGLE = 0;

  /** Highest angle for the trucks platform. */
  private static final double MAX_ANGLE = 70;

  /** The truck's platform. */
  private Platform platform;

  /** The truck the trailer is attached to. */
  private Truck truck;

  /** The car storage. */
  private CarStorage carStorage;

  /** Empty constructor for CarCarrierTrailer. */
  public CarCarrierTrailer(final int maximumAmountOfCarsToStore) {
    this.carStorage = new CarStorage(maximumAmountOfCarsToStore);
    this.platform = new Platform(MIN_ANGLE, MAX_ANGLE);
  }

  /**
   * Adds a car to the storage.
   *
   * @todo Check car position before loading
   * @param car The car to add to the storage.
   */
  public void loadCar(final Car car) {
    if (this.truck instanceof Truck && this.truck == car) {
      throw new IllegalArgumentException(
          "Car carrier trailer can not load the truck it is attached to.");
    }

    this.lowerPlatform();
    this.carStorage.addCar(car);
  }

  /**
   * Unloads a car from the storage, if any cars are loaded.
   *
   * @todo Set car coordinates
   * @param car The car to add to the storage.
   */
  public void unloadCar(final Car car) {
    this.lowerPlatform();
    if (this.carStorage.hasCars()) {
      Car lastLoadedCar = this.carStorage.unload();
    }
  }

  /**
   * Returns the currently loaded cars.
   *
   * @return The currently loaded cars
   */
  public List<Car> getCars() {
    return this.carStorage.getCars();
  }

  /** Raises the platform. */
  public void raisePlatform() {
    if (this.truck instanceof Truck) {
      this.truck.stopEngine();
    }

    this.platform.raise(MAX_ANGLE);
  }

  /** Lowers the platform. */
  public void lowerPlatform() {
    if (this.truck instanceof Truck) {
      this.truck.stopEngine();
    }

    this.platform.raise(-MAX_ANGLE);
  }

  /**
   * Returns the current platform angle.
   *
   * @return The current platform angle
   */
  public double getPlatformAngle() {
    return this.platform.getAngle();
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

  /** Closes the platform before the truck is allowed to move. */
  @Override
  public void safetyProcedures() {
    this.platform.close();
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
   * Returns true if an attachment is attached, false if not
   *
   * @return True if an attachment is attached, false if not
   */
  public boolean isAttached() {
    return this.truck instanceof Truck;
  }
}
