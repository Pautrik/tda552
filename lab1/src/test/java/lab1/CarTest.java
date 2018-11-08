import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.awt.Color;

public class CarTest {

    @Test
    public void getNumberOfDoors() {
        Car saab = new Saab95();
        Car volvo = new Volvo240();
        assertEquals(2, saab.getNumberOfDoors());
        assertEquals(4,volvo.getNumberOfDoors());
    }


    @Test
    public void getEnginePower() {
        Car saab = new Saab95();
        Car volvo = new Volvo240();
        assertEquals(125, saab.getEnginePower(),0);
        assertEquals(100, volvo.getEnginePower(),0);
    }

    @Test
    public void getCurrentSpeed() {
        Car volvo = new Volvo240();
        // First at standstill
        assertEquals(0,volvo.getCurrentSpeed(),0);

        Car saabOne = new Saab95();
        saabOne.gas(10);
        assertEquals(10*0.01*125,saabOne.getCurrentSpeed(),0);

    }

    @Test
    public void getColor() {
        Car saab = new Saab95();
        Color saabColor = Color.red;
        assertEquals(saabColor,saab.getColor());
        Car volvo = new Volvo240();
        Color volvoColor = Color.black;
        assertEquals(volvoColor, volvo.getColor());
    }

    @Test
    public void setColor() {
        Car saab = new Saab95();
        saab.setColor(Color.blue);
        Color saabColor = Color.blue;
        assertEquals(saabColor,saab.color);
    }

    @Test
    public void startEngine() {
        Car saab = new Saab95();
        saab.startEngine();
        assertEquals(0.1, saab.currentSpeed,0);
    }

    @Test
    public void stopEngine() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.stopEngine();
        assertEquals(0,saab.currentSpeed,0);
    }

    @Test
    public void incrementSpeed() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.incrementSpeed(10);
        assertEquals(12.6, saab.currentSpeed,0);
    }

    @Test
    public void decrementSpeed() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.incrementSpeed(10);
        saab.decrementSpeed(5);
        assertEquals(6.35, saab.currentSpeed,0);
    }

    @Test
    public void speedFactor() {
        Saab95 saab = new Saab95();
        assertEquals(125*1*0.01, saab.speedFactor(),0);
        saab.setTurboOn();
        assertEquals(125*1.3*0.01,saab.speedFactor(),0);
    }

    @Test
    public void getX() {
        Car saab = new Saab95();
        assertEquals(saab.x, saab.getX());
        Car volvo = new Volvo240();
        assertEquals(volvo.x, volvo.getX());
    }

    @Test
    public void getY() {
        Car saab = new Saab95();
        assertEquals(saab.y, saab.getY());
        Car volvo = new Volvo240();
        assertEquals(volvo.y, volvo.getY());
    }

    @Test
    public void move() {
        Car saab = new Saab95();
        saab.incrementSpeed(10);
        saab.move();
        assertEquals(12,saab.y,0);
        assertEquals(0, saab.x,0);
    }

    @Test
    public void turnLeft() {
        Car saab = new Saab95();
        saab.turnLeft();
        assertEquals(Car.Direction.LEFT,saab.direction);
    }

    @Test
    public void turnRight() {
        Car saab = new Saab95();
        saab.turnRight();
        assertEquals(Car.Direction.RIGHT,saab.direction);
    }

    @Test
    public void gas() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.gas(10);
        assertEquals(12.6, saab.currentSpeed,0);
    }

    @Test
    public void brake() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.gas(10);
        saab.brake(5);
        assertEquals(6.35,saab.currentSpeed,0);
    }

}
