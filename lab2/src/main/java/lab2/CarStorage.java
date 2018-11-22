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
}
