package lab1;

public class Scania extends Truck{
  @Override
  public double speedFactor() {
    return enginePower * 0.01;
  }
}
