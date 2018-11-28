package lab.model.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleTest {

  private Vehicle vehicle;

  @BeforeEach
  public void setUp() {
    this.vehicle = new CarStub();
  }

  @Test
  public void enginePowerShouldEqualZero() {
    assertEquals(0, this.vehicle.getCurrentSpeed());
  }

  @Test
  public void getCurrentSpeedShouldEqualZero() {
    assertEquals(0, this.vehicle.getCurrentSpeed());
  }

  @Test
  public void colorShouldBeSet() {
    this.vehicle.setColor(Color.BLUE);
    assertEquals(Color.BLUE, this.vehicle.getColor());
  }

  @Test
  public void startEngineShouldIncreaseSpeed() {
    assertEquals(0, this.vehicle.getCurrentSpeed(), "guard, vehicle should be at standstill");

    this.vehicle.startEngine();
    assertEquals(0.1, this.vehicle.getCurrentSpeed());
  }

  @Test
  public void stopEngineShouldStopVehicle() {
    this.vehicle.startEngine();
    assertTrue(0 < this.vehicle.getCurrentSpeed(), "guard, vehicle should not be at standstill");

    this.vehicle.stopEngine();
    assertEquals(0, this.vehicle.getCurrentSpeed());
  }

  @Test
  public void xCoordinateShouldBeZero() {
    assertEquals(0, this.vehicle.getX());
  }

  @Test
  public void yCoordinateShouldBeZero() {
    assertEquals(0, this.vehicle.getY());
  }

  @Test
  public void moveUpShouldUpMoveVehicleUp() {
    this.vehicle.gas(1);
    assertTrue(1 <= this.vehicle.getCurrentSpeed(), "guard, vehicle should not be at standstill");

    this.vehicle.move();

    assertEquals(1, this.vehicle.getY());
    assertEquals(0, this.vehicle.getX(), "default direction is up, x should not be affected");
  }

  @Test
  public void moveRightShouldMoveVehicleRight() {
    this.vehicle.gas(1);
    assertTrue(1 <= this.vehicle.getCurrentSpeed(), "guard, vehicle should not be at standstill");

    // Wrap direction
    this.vehicle.turnRight();
    this.vehicle.turnRight();
    this.vehicle.turnRight();
    this.vehicle.turnRight();
    this.vehicle.turnRight();
    this.vehicle.move();

    assertEquals(0, this.vehicle.getY(), "direction is right, y should not be affected");
    assertEquals(1, this.vehicle.getX());
  }

  @Test
  public void moveLeftShouldMoveVehicleLeft() {
    this.vehicle.gas(1);
    assertTrue(1 <= this.vehicle.getCurrentSpeed(), "guard, vehicle should not be at standstill");

    // Wrap direction
    this.vehicle.turnLeft();
    this.vehicle.turnLeft();
    this.vehicle.turnLeft();
    this.vehicle.turnLeft();
    this.vehicle.turnLeft();
    this.vehicle.move();

    assertEquals(0, this.vehicle.getY(), "direction is left, y should not be affected");
    assertEquals(-1, this.vehicle.getX());
  }

  @Test
  public void moveDownShouldMoveVehicleDown() {
    this.vehicle.gas(1);
    assertTrue(1 <= this.vehicle.getCurrentSpeed(), "guard, vehicle should not be at standstill");

    this.vehicle.turnRight();
    this.vehicle.turnRight();

    this.vehicle.move();

    assertEquals(0, this.vehicle.getX(), "direction is down, x should not be affected");
    assertEquals(-1, this.vehicle.getY());
  }

  @Test
  public void gasShouldIncreaseSpeed() {
    this.vehicle.startEngine();
    assertEquals(0.1, this.vehicle.getCurrentSpeed(), "guard, vehicle should not be at standstill");

    this.vehicle.gas(0.1);
    assertEquals(0.2, this.vehicle.getCurrentSpeed());
  }

  @Test
  public void negativeGasShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.vehicle.gas(-0.1);
        });
  }

  @Test
  public void exceedingGasShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.vehicle.gas(5);
        });
  }

  @Test
  public void brakeShouldDecrease() {
    this.vehicle.startEngine();
    assertEquals(0.1, this.vehicle.getCurrentSpeed(), "guard, vehicle should not be at standstill");

    this.vehicle.brake(0.1);
    assertEquals(0, this.vehicle.getCurrentSpeed());
  }

  @Test
  public void negativeBrakeShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.vehicle.brake(-0.1);
        });
  }

  @Test
  public void exceedingBrakeShouldThrowException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          this.vehicle.brake(5);
        });
  }

  @Test
  public void enginePowerShouldEqualFive() {
    assertEquals(10.0, this.vehicle.getEnginePower());
  }
}
