package lab.model.vehicles;

import java.awt.Color;

public class TransporterStub extends Truck {

  public TransporterStub() {
    super(4, Color.red, 10, "Transporter", 10, 10);
    stopEngine();
  }

  public double speedFactor() {
    return 1;
  }
}
