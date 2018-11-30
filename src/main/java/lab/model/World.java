package lab.model;

import java.awt.*;
import java.util.ArrayList;
import lab.model.vehicles.*;
import lab.model.vehicles.Vehicle;

public class World {
  public static final int WIDTH = 800 - 100; // Shrink world because of images being 100px wide
  public static final int HEIGHT = 400;
  private static final int SPACING_BETWEEN_VEHICLES = 100;

  private ArrayList<Vehicle> vehicles = new ArrayList<>();
  private ArrayList<ViewEntity> viewEntities = new ArrayList<>();

  private Rectangle boundary;

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

  public Rectangle getBoundary() {
    return boundary;
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
