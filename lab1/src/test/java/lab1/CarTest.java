package lab1;
<<<<<<< HEAD

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
=======
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

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
<<<<<<< HEAD
  public void getCurrentSpeedShouldEqualZero() {
=======
  void currentSpeedShouldEqualZero() {
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  void colorShouldBeSet() {
    this.car.setColor(Color.BLUE);
    assertEquals(Color.BLUE, this.car.getColor());
  }

  @Test
<<<<<<< HEAD
  public void startEngineShouldIncreaseSpeed() {
    assertEquals(0, this.car.getCurrentSpeed(), "guard, car should be at standstill");
=======
  void startEngineShouldIncreaseSpeed() {
    assertEquals(0, this.car.currentSpeed, "guard, car should be at standstill");
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

    this.car.startEngine();
    assertEquals(0.1, this.car.getCurrentSpeed());
  }

  @Test
  void stopEngineShouldStopCar() {
    this.car.startEngine();
    assertTrue(0 < this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.stopEngine();
<<<<<<< HEAD
    assertEquals(0, this.car.getCurrentSpeed());
=======
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
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb
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
<<<<<<< HEAD
  public void moveUpShouldUpMoveCarUp() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
=======
  void moveUpShouldUpMoveCarUp() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

    this.car.move();

    assertEquals(1, this.car.getY());
    assertEquals(0, this.car.getX(), "default direction is up, x should not be affected");
  }

  @Test
<<<<<<< HEAD
  public void moveRightShouldMoveCarRight() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
=======
  void moveRightShouldMoveCarRight() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

    // Wrap direction
    this.car.turnRight();
    this.car.turnRight();
    this.car.turnRight();
    this.car.turnRight();
    this.car.turnRight();
    this.car.move();

    assertEquals(0, this.car.getY(), "direction is right, y should not be affected");
    assertEquals(1, this.car.getX());
  }

  @Test
<<<<<<< HEAD
  public void moveLeftShouldMoveCarLeft() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
=======
  void moveLeftShouldMoveCarLeft() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

    // Wrap direction
    this.car.turnLeft();
    this.car.turnLeft();
    this.car.turnLeft();
    this.car.turnLeft();
    this.car.turnLeft();
    this.car.move();

    assertEquals(0, this.car.getY(), "direction is left, y should not be affected");
    assertEquals(-1, this.car.getX());
  }

  @Test
<<<<<<< HEAD
  public void moveDownShouldMoveCarDown() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
=======
  void moveDownShouldMoveCarDown() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb

    this.car.turnRight();
    this.car.turnRight();

    this.car.move();

<<<<<<< HEAD
    assertEquals(0, this.car.getX(), "direction is down, x should not be affected");
    assertEquals(-1, this.car.getY());
=======
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
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb
  }

  @Test
  void gasShouldIncreaseSpeed() {
    this.car.startEngine();
    assertEquals(0.1, this.car.getCurrentSpeed(), "guard, car should not be at standstill");

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
    assertEquals(0.1, this.car.getCurrentSpeed(), "guard, car should not be at standstill");

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
