package lab.model;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

public class RandomVehiclePlacementStrategy implements VehiclePlacementStrategy {
  /**
   * Generates a random point within the given boundary.
   *
   * @param width The boundary width
   * @param width The boundary height
   * @return Point2D The resulting random position
   */
  public Point getVehiclePlacement(final int width, final int height) {
    return new Point(
        ThreadLocalRandom.current().nextInt(World.WIDTH),
        ThreadLocalRandom.current().nextInt(World.HEIGHT));
  }
}
