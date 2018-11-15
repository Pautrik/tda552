import java.awt.Color;

public class CarStub extends Car {

  public CarStub() {
    super(4, Color.red, 10, "Test");
    stopEngine();
  }

  public double speedFactor() {
    return 1;
  }
}
