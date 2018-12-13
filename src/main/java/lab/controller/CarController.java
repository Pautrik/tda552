package lab.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lab.model.*;
import lab.view.CarView;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */
public class CarController {
  // The delay (ms) corresponds to 20 updates a sec (hz)
  private final int delay = 50;

  // The timer is started with an listener (see below) that executes the statements
  // each step between delays.
  private Timer timer = new Timer(delay, new TimerListener());

  private String selectedNewVehicle = "";

  // The frame that represents this instance View of the MVC pattern
  private CarView frame;

  // Model of the world containing all cars and the space they exist in.
  private World world;

  public CarController() {
    this.world = new World();
    this.frame = new CarView("CarSim 1.0", world.getViewEntities()); // , this);
    this.timer.start();

    /* --- Action listeners --- */
    frame.gasButton.addActionListener(e -> gas(frame.gasAmount));
    frame.brakeButton.addActionListener(e -> brake(frame.gasAmount));
    frame.turboOnButton.addActionListener(e -> turboOn());
    frame.turboOffButton.addActionListener(e -> turboOff());
    frame.liftBedButton.addActionListener(e -> raiseRamp());
    frame.lowerBedButton.addActionListener(e -> lowerRamp());
    frame.startButton.addActionListener(e -> startAll());
    frame.stopButton.addActionListener(e -> stopAll());
    frame.addVehicleButton.addActionListener(e -> addVehicle());
    frame.removeVehicleButton.addActionListener(e -> removeLatestVehicle());
    frame.vehicleListBox.addActionListener(
        e -> selectedNewVehicle = (String) ((JComboBox) e.getSource()).getSelectedItem());
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

  private void addVehicle() {
    world.addVehicle(this.selectedNewVehicle);

    if (world.getViewEntities().size() == world.MAXIMUM_AMOUNT_OF_VEHICLES) {
      frame.addVehicleButton.setEnabled(false);
    } else {
      frame.addVehicleButton.setEnabled(true);
      frame.removeVehicleButton.setEnabled(true);
    }
  }

  private void removeLatestVehicle() {
    world.removeLatestVehicle();

    if (world.getViewEntities().size() == 0) {
      frame.removeVehicleButton.setEnabled(false);
    } else {
      frame.removeVehicleButton.setEnabled(true);
      frame.addVehicleButton.setEnabled(true);
    }
  }

  // Calls the gas method for each car once
  private void gas(int amount) {
    world.gas(amount);
  }

  private void brake(int amount) {
    world.brake(amount);
  }

  private void turboOn() {
    world.turboOn();
  }

  private void turboOff() {
    world.turboOff();
  }

  private void raiseRamp() {
    world.raiseRamp();
  }

  private void lowerRamp() {
    world.lowerRamp();
  }

  private void stopAll() {
    world.stopAll();
  }

  private void startAll() {
    world.startAll();
  }
}
