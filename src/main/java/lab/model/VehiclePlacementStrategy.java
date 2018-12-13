package lab.model;

import java.awt.Point;

public interface VehiclePlacementStrategy {
  /**
   * Generates a point within the given boundary.
   *
   * @param width The boundary width
   * @param width The boundary height
   * @return Point2D The resulting position
   */
  public Point getVehiclePlacement(final int width, final int height);
}
