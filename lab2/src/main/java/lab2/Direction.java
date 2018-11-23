package lab2;

/** Direction in a quad-directional grid. */
public enum Direction {
  UP,
  RIGHT,
  DOWN,
  LEFT;

  /**
   * Returns the next direction, going in a clockwise manner.
   *
   * @return Next direction, going in a clockwise manner.
   */
  public Direction getNext() {
    return values()[(ordinal() + 1) % values().length];
  }

  /**
   * Returns the previous direction, going in a counter clockwise manner.
   *
   * @return Previous direction, going in a counter clockwise manner.
   */
  public Direction getPrevious() {
    return this.ordinal() > 0 ? values()[this.ordinal() - 1] : values()[values().length - 1];
  }
};
