package lab.model.vehicles;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

public class TransporterStub extends Truck {

  public TransporterStub() {
    super(4, Color.red, 10, "Transporter");
    stopEngine();
  }

  public double speedFactor() {
    return 1;
  }

  public Point2D getPosition() {
    return new Point(10, 10);
  }
}
