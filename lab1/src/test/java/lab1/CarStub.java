package lab1;

@SuppressWarnings("SameReturnValue")
class CarStub extends Car {

  CarStub() {
    this.enginePower = 10;
  }

  public double speedFactor() {
    return 1;
  }
}
