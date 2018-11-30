package lab.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import lab.model.vehicles.Vehicle;

public class ViewEntity implements Drawable {

  private String name;
  private Vehicle vehicle;

  public ViewEntity(final String name, final Vehicle object) {
    this.name = name;
    this.vehicle = object;
  }

  @Override
  public Point getPosition() {
    return this.vehicle.getPosition();
  }

  public String getName() {
    return this.name;
  }

  @Override
  public BufferedImage getImage() {
    return this.vehicle.getImage();
  }
}
