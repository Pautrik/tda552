package lab1;
<<<<<<< HEAD

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
=======
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Saab95Test {

  private Saab95 car;

  @BeforeEach
  void setUp() {
    this.car = new Saab95();
  }

  @Test
  void setTurboOnShouldActivateTurbo() {
    this.car.setTurboOn();
    assertTrue(this.car.isTurboOn());
  }

  @Test
  void setTurboOffShouldDeactivateTurbo() {
    this.car.setTurboOn();
    assertTrue(this.car.isTurboOn(), "guard, turbo needs to be on");

    this.car.setTurboOff();
    assertFalse(this.car.isTurboOn());
  }

  @Test
  void setTurboShouldAffectSpeedFactor() {
    assertFalse(this.car.isTurboOn(), "guard, turbo needs to be off");
    assertEquals(1.25, this.car.speedFactor());

    this.car.setTurboOn();
    assertTrue(this.car.isTurboOn(), "guard, turbo needs to be on");
    assertEquals(1.625, this.car.speedFactor());
  }
}
