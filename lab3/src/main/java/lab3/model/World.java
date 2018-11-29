package lab3.model;

import lab3.model.vehicles.*;
import lab3.model.vehicles.Vehicle;

import java.awt.*;
import java.util.ArrayList;

public class World {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<ViewEntity> viewEntities = new ArrayList<>();

    private Point worldBoundary;

    public World() {
        worldBoundary = new Point(800,560);

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
            Point position = vehicle.getPosition();
            newEntities.add(new ViewEntity(name, position));
        }
        viewEntities = newEntities;
    }

}
