package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScaniaTest {

  private Scania scania;

  @BeforeEach
  public void setUp() {
    this.scania = new Scania();
  }

  @Test
  public void engineShouldStopBeforePlatformIsRaised() {
    this.scania.startEngine();
    assertTrue(this.scania.getCurrentSpeed() > 0, "guard, truck must not be at standstill");
    this.scania.raisePlatform(10);
    assertEquals(0, this.scania.getCurrentSpeed());
  }

  @Test
  public void engineShouldStopBeforePlatformIsLowered() {
    this.scania.startEngine();
    assertTrue(this.scania.getCurrentSpeed() > 0, "guard, truck must not be at standstill");
    this.scania.lowerPlatform(10);
    assertEquals(0, this.scania.getCurrentSpeed());
  }
}
