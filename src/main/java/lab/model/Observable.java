package lab.model;

public interface Observable {
  void addObserver(WorldObserver observer);

  // void removeObserver(WorldObserver observer);

  void notifyObservers();
}
