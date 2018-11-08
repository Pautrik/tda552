import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Volvo240Test {

  private Volvo240 car;

  @BeforeEach
  public void setUp() {
    this.car = new Volvo240();
  }

  @Test
  public void speedFactorShouldEqualZero() {
    assertEquals(1, this.car.speedFactor());
  }
}
