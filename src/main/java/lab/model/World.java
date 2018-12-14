package lab.model;

import java.awt.*;
import java.util.ArrayList;
import lab.model.vehicles.*;
import lab.model.vehicles.Vehicle;

public class World implements Observable {
  public static final int WIDTH = 800 - 100; // Shrink world because of images being 100px wide
  public static final int HEIGHT = 600;
  private static final int MAX_NUMBER_OF_VEHICLES = 10;
  private static final int SPACING_BETWEEN_VEHICLES = 100;
  public static final int MAXIMUM_AMOUNT_OF_VEHICLES = 10;

  /** Holds the instance in the Singleton pattern */
  private static World instance;

  private VehicleFactory factory = new VehicleFactory();
  private ArrayList<Vehicle> vehicles = new ArrayList<>();

  private void setViewEntities() {
    this.viewEntities.clear();

    for (Vehicle vehicle : this.vehicles) {
      String name = vehicle.getModelName();
      this.viewEntities.add(new ViewEntity(name, vehicle));
    }
  }

  public ArrayList<ViewEntity> getViewEntities() {
    return viewEntities;
  }

  /**
   * Creates the world, if there is none, and returns the instance. Implements the singleton
   * pattern.
   *
   * @return The World instance, being a singleton
   */
  public static final World getInstance() {
    if (instance == null) {
      instance = new World();
    }

    return instance;
  }

  public void addVehicle(VehicleFactory.VehicleType input, int x, int y) {
    Vehicle vehicle = factory.makeVehicle(input, x, y);
    this.vehicles.add(vehicle);
    setViewEntities();
  }

  public void addVehicle(String input, int x, int y) {
    Vehicle vehicle = factory.makeVehicle(input, x, y);
    this.vehicles.add(vehicle);
    setViewEntities();
  }

  public void addVehicle(String input) {
    Vehicle vehicle = factory.makeVehicle(input);
    this.vehicles.add(vehicle);
    setViewEntities();
  }

  public void removeLatestVehicle() {
    if (vehicles.size() > 0) {
      this.vehicles.remove(vehicles.size() - 1);
      setViewEntities();
    }
  }

  private Rectangle boundary;
  /* --- Observer stuff --- */
  // List of observers

  private ArrayList<WorldObserver> observers = new ArrayList<>();

  public void addObserver(WorldObserver observer) {
    observers.add(observer);
  }

  public void notifyObservers() {
    for (WorldObserver observer : observers) observer.actOnWorldChange();
  }

  /* --- END --- */

  /* --- Observer stuff --- */
  private ArrayList<ViewEntity> viewEntities = new ArrayList<>();

  private World() {
    boundary = new Rectangle(WIDTH, HEIGHT);

    addVehicle(VehicleFactory.VehicleType.VOLVO, 0, 0);
    addVehicle(VehicleFactory.VehicleType.SAAB, 0, SPACING_BETWEEN_VEHICLES);
    addVehicle(VehicleFactory.VehicleType.SCANIA, 0, SPACING_BETWEEN_VEHICLES * 2);

    setViewEntities();
  }

  public void moveVehicles() {
    for (Vehicle vehicle : vehicles) {
      vehicle.move();
    }
  }

  public void gas(int amount) {
    double gas = ((double) amount) / 100;
    for (Vehicle vehicle : vehicles) {
      vehicle.gas(gas);
    }
  }

  public void brake(int amount) {
    double brake = ((double) amount) / 100;
    for (Vehicle vehicle : vehicles) {
      vehicle.brake(brake);
    }
  }

  public void turboOn() {
    for (Vehicle vehicle : vehicles) {
      if (vehicle instanceof Saab95) {
        ((Saab95) vehicle).setTurboOn();
      }
    }
  }

  public void turboOff() {
    for (Vehicle vehicle : vehicles) {
      if (vehicle instanceof Saab95) {
        ((Saab95) vehicle).setTurboOff();
      }
    }
  }

  public void raiseRamp() {
    for (Vehicle vehicle : vehicles) {
      if (vehicle instanceof Truck) {
        Attachable trailer = ((Truck) vehicle).getAttachment();
        ((Trailer) trailer).raiseRamp();
      }
    }
  }

  public void lowerRamp() {
    for (Vehicle vehicle : vehicles) {
      if (vehicle instanceof Truck) {
        Attachable trailer = ((Truck) vehicle).getAttachment();
        ((Trailer) trailer).lowerRamp();
      }
    }
  }

  public void stopAll() {
    for (Vehicle vehicle : vehicles) {
      vehicle.stopEngine();
    }
  }

  public void startAll() {
    for (Vehicle vehicle : vehicles) {
      vehicle.startEngine();
    }
  }

  public void keepVehiclesInsideBoundary() {
    for (Vehicle vehicle : vehicles) {
      if (!boundary.contains(vehicle.getPosition())) {
        vehicle.turnLeft();
        vehicle.turnLeft();
      }
    }
  }
}
