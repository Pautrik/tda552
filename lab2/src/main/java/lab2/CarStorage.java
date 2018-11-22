package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarStorage {
  /** The stored cars. */
  private List<Car> cars;

  /** Empty constructor for CarStorage. */
  public CarStorage(final int maximumAmountOfCarsToStore) {
    this.cars = new ArrayList<Car>(maximumAmountOfCarsToStore);
  }

  /**
   * Returns the currently loaded cars as an immutable list.
   *
   * @return The currently loaded cars as an immutable list
   */
  public List<Car> getCars() {
    return Collections.unmodifiableList(this.cars);
  }

  /**
   * Adds a car to the storage.
   *
   * @param car The car to add
   */
  public void addCar(final Car car) {
    this.cars.add(car);
  }

  /**
   * Returns true if any cars are loaded.
   *
   * @return True if any cars are loaded, otherwise false
   */
  public boolean hasCars() {
    return this.cars.size() > 0;
  }

  /**
   * Unloads the last loaded car. If no cars are loaded an exception is thrown.
   *
   * @throws IndexOutOfBoundsException If no cars are loaded
   */
  public Car unload() {
    try {
      Car lastLoadedCar = this.cars.get(this.cars.size() - 1);
      this.cars.remove(lastLoadedCar);

      return lastLoadedCar;
    } catch (IndexOutOfBoundsException exception) {
      throw exception;
    }
  }
}
