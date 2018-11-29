package lab3.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab3.view.CarView;
import lab3.model.vehicles.*;
import lab3.model.*;
import lab3.view.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:S

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;

    // Model of the world containing all cars and the space they exist in.
    public World world;

    public CarController() {
        this.world = new World();
        this.frame = new CarView("CarSim 1.0", this);
        this.timer.start();
    }

    public static void main(String[] args) {
        new CarController();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.moveVehicles();
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : world.getVehicles()) {
            vehicle.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : world.getVehicles()) {
            vehicle.brake(brake);
        }
    }

    public void turboOn() {

    }

    public void turboOff() {

    }

    public void liftBed() {

    }

    public void lowerBed() {

    }

    public void stopAll() {

    }

    public void startAll() {

    }
}
