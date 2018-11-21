package lab2;

/** Generic movable. */
public interface Movable {
  /** Moves the entity in the current direction. */
  public void move();

  /** Turns the entity left. */
  public void turnLeft();

  /** Turns the entity right. */
  public void turnRight();
}
