package lab1;
<<<<<<< HEAD

import static org.junit.jupiter.api.Assertions.assertEquals;
=======
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Volvo240Test {

  private Volvo240 car;

  @BeforeEach
  void setUp() {
    this.car = new Volvo240();
  }

  @Test
  void speedFactorShouldEqualZero() {
    assertEquals(1.25, this.car.speedFactor());
  }
}
