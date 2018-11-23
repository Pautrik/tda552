package lab2.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
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

  @Test
  public void enginePowerShouldEqualZero() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  public void getCurrentSpeedShouldEqualZero() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  public void colorShouldBeSet() {
    this.car.setColor(Color.BLUE);
    assertEquals(Color.BLUE, this.car.getColor());
  }

  @Test
  public void startEngineShouldIncreaseSpeed() {
    assertEquals(0, this.car.getCurrentSpeed(), "guard, car should be at standstill");

    this.car.startEngine();
    assertEquals(0.1, this.car.getCurrentSpeed());
  }

  @Test
  public void stopEngineShouldStopCar() {
    this.car.startEngine();
    assertTrue(0 < this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.stopEngine();
    assertEquals(0, this.car.getCurrentSpeed());
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
  public void moveUpShouldUpMoveCarUp() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.move();

    assertEquals(1, this.car.getY());
    assertEquals(0, this.car.getX(), "default direction is up, x should not be affected");
  }

  @Test
  public void moveRightShouldMoveCarRight() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

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
  public void moveLeftShouldMoveCarLeft() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

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
  public void moveDownShouldMoveCarDown() {
    this.car.gas(1);
    assertTrue(1 <= this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.turnRight();
    this.car.turnRight();

    this.car.move();

    assertEquals(0, this.car.getX(), "direction is down, x should not be affected");
    assertEquals(-1, this.car.getY());
  }

  @Test
  public void gasShouldIncreaseSpeed() {
    this.car.startEngine();
    assertEquals(0.1, this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.gas(0.1);
    assertEquals(0.2, this.car.getCurrentSpeed());
  }

  @Test
  public void negativeGasShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.car.gas(-0.1);
        });
  }

  @Test
  public void exceedingGasShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.car.gas(5);
        });
  }

  @Test
  public void brakeShouldDecrease() {
    this.car.startEngine();
    assertEquals(0.1, this.car.getCurrentSpeed(), "guard, car should not be at standstill");

    this.car.brake(0.1);
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  public void negativeBrakeShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.car.brake(-0.1);
        });
  }

  @Test
  public void exceedingBrakeShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.car.brake(5);
        });
  }

  @Test
  public void enginePowerShouldEqualFive() {
    assertEquals(10.0, this.car.getEnginePower());
  }
}
