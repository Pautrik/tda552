package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TruckTest {

  private TruckStub truck;

  @BeforeEach
  public void setUp() {
    this.truck = new TruckStub();
  }

  @Test
  public void engineShouldStopBeforePlatformIsRaised() {
    this.truck.startEngine();
    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck must not be at standstill");
    this.truck.raisePlatform(10);
    assertEquals(0, this.truck.getCurrentSpeed());
  }

  @Test
  public void engineShouldStopBeforePlatformIsLowered() {
    this.truck.startEngine();
    assertTrue(this.truck.getCurrentSpeed() > 0, "guard, truck must not be at standstill");
    this.truck.lowerPlatform(10);
    assertEquals(0, this.truck.getCurrentSpeed());
  }
}
