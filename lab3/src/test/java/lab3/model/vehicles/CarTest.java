package lab3.model.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

  private CarStub car;

  @BeforeEach
  public void setUp() {
    this.car = new CarStub();
  }

  @Test
  public void numberOfDoorsShouldEqualFour() {
    assertEquals(4, this.car.getNumberOfDoors());
  }
}
