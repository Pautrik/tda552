package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarCarrierTrailerTest {

  private TruckStub truck;
  private CarCarrierTrailer carCarrierTrailer;

  @BeforeEach
  public void setUp() {
    this.truck = new TruckStub();
    this.carCarrierTrailer = new CarCarrierTrailer(1);
    this.carCarrierTrailer.attachTo(this.truck);
  }

  @Test
  public void engineShouldStopBeforePlatformIsRaised() {
    this.truck.startEngine();
    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck must not be at standstill");

    this.carCarrierTrailer.raisePlatform(10);
    assertEquals(0, this.truck.getCurrentSpeed());
  }

  @Test
  public void engineShouldStopBeforePlatformIsLowered() {
    this.truck.startEngine();
    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck must not be at standstill");

    this.carCarrierTrailer.lowerPlatform(10);
    assertEquals(0, this.truck.getCurrentSpeed());
  }

  @Test
  public void platformShouldBeClosedBeforeMoving() {
    this.carCarrierTrailer.raisePlatform(10);

    assertEquals(0, this.truck.getCurrentSpeed(), "guard, truck must be at standstill");
    assertTrue(
        this.carCarrierTrailer.getPlatformAngle() > 0, "guard, platform angle must not be zero");

    this.truck.startEngine();
    this.truck.gas(1);
    this.truck.move();

    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck should be moving");
    assertEquals(0, this.carCarrierTrailer.getPlatformAngle());
  }
}
