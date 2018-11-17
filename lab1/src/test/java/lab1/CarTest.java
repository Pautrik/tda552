package lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

  private lab1.CarStub car;

  @BeforeEach
  void setUp() {
    this.car = new CarStub();
  }

  @Test
  void numberOfDoorsShouldEqualFour() {
    assertEquals(4, this.car.getNumberOfDoors());
  }

  @Test
  void enginePowerShouldEqualZero() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  void currentSpeedShouldEqualZero() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  void colorShouldBeSet() {
    this.car.setColor(Color.BLUE);
    assertEquals(Color.BLUE, this.car.getColor());
  }

  @Test
  void startEngineShouldIncreaseSpeed() {
    assertEquals(0, this.car.currentSpeed, "guard, car should be at standstill");

    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed);
  }

  @Test
  void stopEngineShouldStopCar() {
    this.car.startEngine();
    assertTrue(0 < this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.stopEngine();
    assertEquals(0, this.car.currentSpeed);
  }

  @Test
  void incrementSpeedShouldIncreaseSpeed() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.incrementSpeed(5);
    assertEquals(5.1, this.car.currentSpeed);
  }

  @Test
  void incrementSpeedCanNotExceedEnginePower() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed, "guard, car should not be at standstill");

    assertThrows(
        IllegalArgumentException.class,
        () -> this.car.incrementSpeed(10));
  }

  @Test
  void decrementSpeedShouldDecreaseSpeed() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.decrementSpeed(0.1);
    assertEquals(0, this.car.currentSpeed);
  }

  @Test
  void xCoordinateShouldBeZero() {
    assertEquals(0, this.car.getX());
  }

  @Test
  void yCoordinateShouldBeZero() {
    assertEquals(0, this.car.getY());
  }

  @Test
  void moveUpShouldUpMoveCarUp() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.move();

    assertEquals(10, this.car.y);
    assertEquals(0, this.car.x, "default direction is up, x should not be affected");
  }

  @Test
  void moveRightShouldMoveCarRight() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.turnRight();
    this.car.move();

    assertEquals(0, this.car.y, "direction is right, y should not be affected");
    assertEquals(10, this.car.x);
  }

  @Test
  void moveLeftShouldMoveCarLeft() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.turnLeft();
    this.car.move();

    assertEquals(0, this.car.y, "direction is left, y should not be affected");
    assertEquals(-10, this.car.x);
  }

  @Test
  void moveDownShouldMoveCarDown() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.turnRight();
    this.car.turnRight();

    this.car.move();

    assertEquals(0, this.car.x, "direction is down, x should not be affected");
    assertEquals(-10, this.car.y);
  }

  @Test
  void turnLeftShouldTurnCarLeft() {
    this.car.turnLeft();
    assertEquals(Car.Direction.LEFT, this.car.direction);
  }

  @Test
  void turnRightShouldTurnCarRight() {
    this.car.turnRight();
    assertEquals(Car.Direction.RIGHT, this.car.direction);
  }

  @Test
  void turnLeftWhenFacingRightShouldWrapDirection() {
    this.car.turnRight();
    this.car.turnLeft();
    assertEquals(Car.Direction.UP, this.car.direction);
  }

  @Test
  void turnRightWhenFacingLeftShouldWrapDirection() {
    this.car.turnLeft();
    this.car.turnRight();
    assertEquals(Car.Direction.UP, this.car.direction);
  }

  @Test
  void gasShouldIncreaseSpeed() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.gas(0.1);
    assertEquals(0.2, this.car.getCurrentSpeed());
  }

  @Test
  void negativeGasShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> this.car.gas(-0.1));
  }

  @Test
  void exceedingGasShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> this.car.gas(5));
  }

  @Test
  void brakeShouldDecrease() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed, "guard, car should not be at standstill");

    this.car.brake(0.1);
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  void negativeBrakeShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> this.car.brake(-0.1));
  }

  @Test
  void exceedingBrakeShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> this.car.brake(5));
  }

  @Test
  void enginePowerShouldEqualFive() {
    assertEquals(10.0, this.car.getEnginePower());
  }
}
