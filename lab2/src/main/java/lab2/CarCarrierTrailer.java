package lab2;

import java.util.List;

/** A car carrier trailer for trucks. */
public class CarCarrierTrailer implements Attachable {
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
   * @param car The car to add to the storage.
   */
  public void loadCar(final Car car) {
    this.carStorage.addCar(car);
  }

  /**
   * Unloads a car from the storage, if any cars are loaded.
   *
   * @todo Set car coordinates
   * @todo Check platform before unloading
   * @param car The car to add to the storage.
   */
  public void unloadCar(final Car car) {
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

  /**
   * Tries to raise platform with the parameter degrees. The new platform angle value will never
   * exceed MAX_ANGLE. The truck will stop before the platform is raised.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to raise trucks' the platform. May be negative.
   */
  public void raisePlatform(final double degrees) {
    if (this.truck instanceof Truck) {
      this.truck.stopEngine();
    }
    this.platform.raise(degrees);
  }

  /**
   * Tries to lower platform with the parameter degrees The new platform angle value will never be
   * less than MIN_ANGLE. Any attached truck will stop before the platform is lowered.
   *
   * @see minAngle
   * @see maxAngle
   * @param degrees Degrees to lower the trucks' platform. May be negative.
   */
  public void lowerPlatform(final double degrees) {
    this.raisePlatform(-degrees);
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

    truck.setAttachment(this);
    this.truck = truck;
  }

  /** Detaches the trailer if attached to a truck. */
  @Override
  public void detach() {
    if (this.truck instanceof Truck) {
      this.x = this.truck.getX();
      this.y = this.truck.getY();

      this.truck.detachAttachment();
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
}
