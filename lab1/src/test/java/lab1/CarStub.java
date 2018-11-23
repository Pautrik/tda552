package lab1;
<<<<<<< HEAD

import java.awt.Color;

public class CarStub extends Car {

  public CarStub() {
    super(4, Color.red, 10, "Test");
    stopEngine();
=======

@SuppressWarnings("SameReturnValue")
class CarStub extends Car {

  CarStub() {
    this.enginePower = 10;
>>>>>>> 8de9ef940189a11b7e59a2b8dac1964200ce23eb
  }

  public double speedFactor() {
    return 1;
  }
}
