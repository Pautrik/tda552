package lab.model;

import java.awt.*;

public class ViewEntity implements Positionable {

  private String name;
  private Point position;

  public ViewEntity(String name, Point position) {
    this.position = position;
    this.name = name;
  }

  @Override
  public Point getPosition() {
    return position;
  }

  public void setPosition(Point position) {
    this.position = position;
  }

  public String getName() {
    return name;
  }
}
