package lab2;

/** Generic movable. */
public interface Movable {
  /** Moves the movable in the current direction. */
  public void move();

  /** Pushes the movable 1 unit in the given direction. */
  public void pushInDirection(final Direction direction);
}
