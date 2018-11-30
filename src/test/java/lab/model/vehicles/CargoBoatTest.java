package lab.model.vehicles;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CargoBoatTest {

  private CargoBoat cargoBoat;

  @BeforeEach
  public void setUp() {
    this.cargoBoat = new CargoBoat(2, Color.RED, 100, "Boaty McBoatface", 0, 0);
  }

  @Test
  public void unloadShouldStartWithFirstCar() {
    Car firstCar = new CarStub();
    Car lastCar = new CarStub();

    this.cargoBoat.load(firstCar);
    this.cargoBoat.load(lastCar);

    assertTrue(firstCar == this.cargoBoat.unload());
    assertTrue(lastCar == this.cargoBoat.unload());
  }

  @Test
  public void testLoadingBeyondCapacityShouldThrowException() {
    Car firstCar = new CarStub();
    Car secondCar = new CarStub();
    Car thirdCar = new CarStub();

    this.cargoBoat.load(firstCar);
    this.cargoBoat.load(secondCar);

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> {
          this.cargoBoat.load(thirdCar);
        });
  }
}
