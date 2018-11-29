package lab.model;

import java.awt.*;
import java.awt.image.BufferedImage;

/** Drawables which can be represented with an image. */
public interface Drawable extends Positionable {

  /**
   * Returns the file image representing the object.
   *
   * @return File The file representing the object
   */
  public BufferedImage getImage();
}
