package lab1;

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
