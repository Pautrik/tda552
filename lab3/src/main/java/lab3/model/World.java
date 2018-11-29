package lab3.model;

import lab3.model.vehicles.*;
import lab3.model.vehicles.Vehicle;

import java.awt.*;
import java.util.ArrayList;

public class World {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Point worldBoundary;

    public World() {
        worldBoundary = new Point(800,560);

        vehicles.add(new Volvo240());
        vehicles.add(new Saab95());
        vehicles.add(new Scania());
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public Point getWorldBoundary() {
        return worldBoundary;
    }

}
