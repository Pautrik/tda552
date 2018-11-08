import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

  private Car car;

  @BeforeEach
  public void setUp() {
    this.car = new CarStub();
  }

  @Test
  public void numberOfDoorsShouldEqualFour() {
    assertEquals(4, this.car.getNumberOfDoors());
  }

  @Test
  public void enginePowerShouldEqualZero() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  public void currentSpeedShouldEqualZero() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  public void colorShouldBeSet() {
    this.car.setColor(Color.BLUE);
    assertEquals(Color.BLUE, this.car.getColor());
  }

  @Test
  public void startEngineShouldIncreaseSpeed() {
    assertEquals(0, this.car.currentSpeed, "guard, car should be at standstill");

    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed);
  }

  @Test
  public void stopEngineShouldStopCar() {
    this.car.startEngine();
    assertTrue(0 < this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.stopEngine();
    assertEquals(0, this.car.currentSpeed);
  }

  @Test
  public void incrementSpeedShouldIncreaseSpeed() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.incrementSpeed(10);
    assertEquals(10.1, this.car.currentSpeed);
  }

  @Test
  public void decrementSpeedShouldDecreaseSpeed() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.decrementSpeed(0.1);
    assertEquals(0, this.car.currentSpeed);
  }

  @Test
  public void xCoordinateShouldBeZero() {
    assertEquals(0, this.car.getX());
  }

  @Test
  public void yCoordinateShouldBeZero() {
    assertEquals(0, this.car.getY());
  }

  @Test
  public void moveShouldMoveCarInCurrentDirection() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.move();

    assertEquals(10, this.car.y);
    assertEquals(0, this.car.x, "default direction is up, x should not be affected");
  }

  @Test
  public void turnLeftShouldTurnCarLeft() {
    this.car.turnLeft();
    assertEquals(Car.Direction.LEFT, this.car.direction);
  }

  @Test
  public void turnRightShouldTurnCarRight() {
    this.car.turnRight();
    assertEquals(Car.Direction.RIGHT, this.car.direction);
  }

  @Test
  /** @todo Not yet implemented in Car */
  public void gas() {
    assertTrue(true);
  }

  @Test
  /** @todo Not yet implemented in Car */
  public void brake() {
    assertTrue(true);
  }
}
