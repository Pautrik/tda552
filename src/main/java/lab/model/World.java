package lab.model;

import java.awt.*;
import java.util.ArrayList;
import lab.model.vehicles.*;
import lab.model.vehicles.Vehicle;

public class World implements Observable {
  public static final int WIDTH = 800 - 100; // Shrink world because of images being 100px wide
  public static final int HEIGHT = 400;
  private static final int SPACING_BETWEEN_VEHICLES = 100;

  private ArrayList<Vehicle> vehicles = new ArrayList<>();

  private Rectangle boundary;

  /* --- Observer stuff --- */
  // List of observers
  private ArrayList<WorldObserver> observers = new ArrayList<>();

  public void addObserver(WorldObserver observer) {
    observers.add(observer);
  }

  public void notifyObservers() {
    for (WorldObserver observer : observers)
      observer.actOnWorldChange();
  }
  /* --- END --- */

  private void setViewEntities(ArrayList<Vehicle> vehicles) {
    ArrayList<ViewEntity> newEntities = new ArrayList<>();

    for (Vehicle vehicle : vehicles) {
      String name = vehicle.getModelName();
      newEntities.add(new ViewEntity(name, vehicle));
    }

    this.viewEntities = newEntities;
  }

  public ArrayList<ViewEntity> getViewEntities() {
    return viewEntities;
  }

  /* --- Observer stuff --- */
  private ArrayList<ViewEntity> viewEntities = new ArrayList<>();

  public World() {
    boundary = new Rectangle(WIDTH, HEIGHT);

    vehicles.add(new Volvo240(0, 0));
    vehicles.add(new Saab95(0, SPACING_BETWEEN_VEHICLES));

    Truck scania = new Scania(0, SPACING_BETWEEN_VEHICLES * 2);
    Trailer<Car> trailer = new Trailer<>(1);
    trailer.attachTo(scania);
    vehicles.add(scania);

    setViewEntities(vehicles);
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
