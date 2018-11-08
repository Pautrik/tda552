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
  public void getNumberOfDoors() {
    assertEquals(4, this.car.getNumberOfDoors());
  }

  @Test
  public void getEnginePower() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  public void getCurrentSpeed() {
    assertEquals(0, this.car.getCurrentSpeed());
  }

  @Test
  public void getColor() {
    this.car.setColor(Color.BLUE);
    assertEquals(Color.BLUE, this.car.getColor());
  }

  @Test
  public void setColor() {
    this.car.setColor(Color.blue);
    assertEquals(Color.blue, this.car.getColor());
  }

  @Test
  public void startEngine() {
    this.car.startEngine();
    assertEquals(0.1, this.car.currentSpeed);
  }

  @Test
  public void stopEngine() {
    this.car.startEngine();
    assertTrue(0 < this.car.currentSpeed, "guard");

    this.car.stopEngine();
    assertEquals(0, this.car.currentSpeed);
  }

  @Test
  public void incrementSpeed() {
    this.car.startEngine();
    this.car.incrementSpeed(10);

    assertEquals(10.1, this.car.currentSpeed);
  }

  @Test
  public void decrementSpeed() {
    this.car.startEngine();
    assertTrue(0.1 <= this.car.currentSpeed);

    this.car.decrementSpeed(0.1);
    assertEquals(0, this.car.currentSpeed);
  }

  @Test
  public void getX() {
    assertEquals(0, this.car.getX());
  }

  @Test
  public void getY() {
    assertEquals(0, this.car.getY());
  }

  @Test
  public void move() {
    this.car.incrementSpeed(10);
    assertTrue(10 <= this.car.getCurrentSpeed());

    this.car.move();

    assertEquals(10, this.car.y);
    assertEquals(0, this.car.x, "guard, default direction is up");
  }

  @Test
  public void turnLeft() {
    this.car.turnLeft();
    assertEquals(Car.Direction.LEFT, this.car.direction);
  }

  @Test
  public void turnRight() {
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
