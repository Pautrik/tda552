package lab.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lab.model.vehicles.Car;
import lab.model.vehicles.CarStub;
import lab.model.vehicles.TruckStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrailerTest {

  private TruckStub truck;
  private Trailer<Car> trailer;

  @BeforeEach
  public void setUp() {
    this.truck = new TruckStub();
    this.trailer = new Trailer<Car>(2);
    this.trailer.attachTo(this.truck);
  }

  @Test
  public void engineShouldStopBeforeRampIsRaised() {
    this.truck.startEngine();
    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck must not be at standstill");

    this.trailer.raiseRamp();
    assertEquals(0, this.truck.getCurrentSpeed());
  }

  @Test
  public void engineShouldStopBeforeRampIsLowered() {
    this.truck.startEngine();
    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck must not be at standstill");

    this.trailer.lowerRamp();
    assertEquals(0, this.truck.getCurrentSpeed());
  }

  @Test
  public void rampShouldBeClosedBeforeMoving() {
    this.trailer.raiseRamp();

    assertEquals(0, this.truck.getCurrentSpeed(), "guard, truck must be at standstill");
    assertTrue(this.trailer.getRampAngle() > 0, "guard, ramp angle must not be zero");

    this.truck.startEngine();
    this.truck.gas(1);
    this.truck.move();

    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck should be moving");
    assertEquals(0, this.trailer.getRampAngle());
  }

  @Test
  public void unloadShouldStartWithLastCar() {
    Car firstCar = new CarStub();
    Car lastCar = new CarStub();

    this.trailer.load(firstCar);
    this.trailer.load(lastCar);

    assertTrue(lastCar == this.trailer.unload());
    assertTrue(firstCar == this.trailer.unload());
  }

  @Test
  public void testLoadingBeyondCapacityShouldThrowException() {
    Car firstCar = new CarStub();
    Car secondCar = new CarStub();
    Car thirdCar = new CarStub();

    this.trailer.load(firstCar);
    this.trailer.load(secondCar);

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> {
          this.trailer.load(thirdCar);
        });
  }
}
