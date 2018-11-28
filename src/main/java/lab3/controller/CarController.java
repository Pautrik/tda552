package lab3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import lab3.model.*;
import lab3.model.vehicles.*;
import lab3.view.*;
import lab3.view.CarView;

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
  // A list of cars, modify if needed
  private ArrayList<Car> cars = new ArrayList<>();

  // methods:

  public static void main(String[] args) {
    // Instance of this class
    CarController cc = new CarController();

    cc.cars.add(new Volvo240());

    // Start a new view and send a reference of self
    cc.frame = new CarView("CarSim 1.0", cc);

    // Start the timer
    cc.timer.start();
  }

  /* Each step the TimerListener moves all the cars in the list and tells the
   * view to update its images. Change this method to your needs.
   * */
  private class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      for (Car car : cars) {
        car.move();
        int x = (int) Math.round(car.getPosition().getX());
        int y = (int) Math.round(car.getPosition().getY());
        frame.drawPanel.moveit(x, y);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
      }
    }
  }

  // Calls the gas method for each car once
  public void gas(int amount) {
    double gas = ((double) amount) / 100;
    for (Car car : cars) {
      car.gas(gas);
    }
  }

  public void brake(int amount) {
    double brake = ((double) amount) / 100;
    for (Car car : cars) {
      car.brake(brake);
    }
  }

  public void turboOn() {}

  public void turboOff() {}

  public void liftBed() {}

  public void lowerBed() {}

  public void stopAll() {}

  public void startAll() {}
}
