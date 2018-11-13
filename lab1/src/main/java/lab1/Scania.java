package src.main.java.lab1;

public class Scania extends Truck{
  @Override
  public double speedFactor() {
    return enginePower * 0.01;
  }
}
