package lab.model;

import java.awt.*;
import java.util.ArrayList;
import lab.model.vehicles.*;
import lab.model.vehicles.Vehicle;

public class World {

  private ArrayList<Vehicle> vehicles = new ArrayList<>();
  private ArrayList<ViewEntity> viewEntities = new ArrayList<>();

  private Point worldBoundary;

  public World() {
    worldBoundary = new Point(800, 560);

    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new Scania());

    setViewEntities(vehicles);
  }

  public ArrayList<ViewEntity> getViewEntities() {
    return viewEntities;
  }

  public ArrayList<Vehicle> getVehicles() {
    return vehicles;
  }

  public void moveVehicles() {
    for (Vehicle vehicle : this.getVehicles()) {
      vehicle.move();
    }
  }

  public Point getWorldBoundary() {
    return worldBoundary;
  }

  private void setViewEntities(ArrayList<Vehicle> vehicles) {
    ArrayList<ViewEntity> newEntities = new ArrayList<>();
    for (Vehicle vehicle : vehicles) {
      String name = vehicle.getModelName();
      newEntities.add(new ViewEntity(name, vehicle));
    }
    viewEntities = newEntities;
  }
}
