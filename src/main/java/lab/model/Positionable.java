package lab.model;

import java.awt.*;

/** Generic positionable in x-/y-plane */
public interface Positionable {
  /**
   * Returns the 2D coordinate.
   *
   * @return x,y-position of the Positionable
   */
  public Point getPosition();
}
