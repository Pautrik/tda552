package lab.model;

import java.awt.geom.Point2D;

/** Generic positionable in x-/y-plane */
public interface Positionable {
  /**
   * Returns the 2D coordinate.
   *
   * @return x,y-position of the Positionable
   */
  public Point2D getPosition();
}
