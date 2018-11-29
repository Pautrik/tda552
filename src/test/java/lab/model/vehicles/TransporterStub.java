package lab.model.vehicles;

import java.awt.Color;
import java.awt.Point;

public class TransporterStub extends Truck {

  public TransporterStub() {
    super(4, Color.red, 10, "Transporter");
    stopEngine();
  }

  public double speedFactor() {
    return 1;
  }

  public Point getPosition() {
    return new Point(10, 10);
  }
}
