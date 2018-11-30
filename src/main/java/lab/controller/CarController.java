package lab.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lab.model.*;
import lab.model.vehicles.*;
import lab.view.*;
import lab.view.CarView;

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

  /**
   * Each step the TimerListener moves all the cars in the list and tells the view to update its
   * images. Change this method to your needs.
   */
  private class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      world.keepVehiclesInsideBoundary();
      world.moveVehicles();
      frame.drawPanel.repaint();
    }
  }

  // Calls the gas method for each car once
  public void gas(int amount) {
    world.gas(amount);
  }

  public void brake(int amount) {
    world.brake(amount);
  }

  public void turboOn() {
    world.turboOn();
  }

  public void turboOff() {
    world.turboOff();
  }

  public void raiseRamp() {
    world.raiseRamp();
  }

  public void lowerRamp() {
    world.lowerRamp();
  }

  public void stopAll() {
    world.stopAll();
  }

  public void startAll() {
    world.startAll();
  }
}
