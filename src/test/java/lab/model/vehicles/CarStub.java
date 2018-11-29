package lab.model.vehicles;

import java.awt.Color;

public class CarStub extends Car {

  public CarStub() {
    super(4, Color.red, 10, "Test", 0, 0);
    stopEngine();
  }

  public double speedFactor() {
    return 1;
  }
}
