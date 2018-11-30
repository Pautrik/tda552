package lab.model.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Volvo240Test {

  private Volvo240 car;

  @BeforeEach
  public void setUp() {
    this.car = new Volvo240(0, 0);
  }

  @Test
  public void speedFactorShouldOnePointTwentyFive() {
    assertEquals(1.25, this.car.speedFactor());
  }
}
