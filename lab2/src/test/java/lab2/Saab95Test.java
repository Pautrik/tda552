package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Saab95Test {

  private Saab95 car;

  @BeforeEach
  public void setUp() {
    this.car = new Saab95();
  }

  @Test
  public void setTurboOnShouldActivateTurbo() {
    this.car.setTurboOn();
    assertTrue(this.car.isTurboOn());
  }

  @Test
  public void setTurboOffShouldDeactivateTurbo() {
    this.car.setTurboOn();
    assertTrue(this.car.isTurboOn(), "guard, turbo needs to be on");

    this.car.setTurboOff();
    assertFalse(this.car.isTurboOn());
  }

  @Test
  public void setTurboShouldAffectSpeedFactor() {
    assertFalse(this.car.isTurboOn(), "guard, turbo needs to be off");
    assertEquals(1.25, this.car.speedFactor());

    this.car.setTurboOn();
    assertTrue(this.car.isTurboOn(), "guard, turbo needs to be on");
    assertEquals(1.625, this.car.speedFactor());
  }
}
