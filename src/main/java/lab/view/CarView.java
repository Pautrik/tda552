package lab.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import lab.model.VehicleFactory;
import lab.model.ViewEntity;
import lab.model.World;
import lab.model.WorldObserver;

/**
 * This class represents the full view of the MVC pattern of your car simulator. It initializes with
 * being center on the screen and attaching it's controller in it's state. It communicates with the
 * Controller by calling methods of it when an action fires of in each of it's components.
 */
public class CarView extends JFrame implements WorldObserver {
  public DrawPanel drawPanel;
  private JPanel controlPanel = new JPanel();
  private static final int WIDTH = World.WIDTH + 100;

  private JPanel gasPanel = new JPanel();
  private JSpinner gasSpinner = new JSpinner();
  public int gasAmount = 0;
  private JLabel gasLabel = new JLabel("Amount of gas");

  public JButton gasButton = new JButton("Gas");
  public JButton brakeButton = new JButton("Brake");
  public JButton turboOnButton = new JButton("Saab Turbo on");
  public JButton turboOffButton = new JButton("Saab Turbo off");
  public JButton liftBedButton = new JButton("Scania Lift Bed");
  public JButton lowerBedButton = new JButton("Lower Lift Bed");
  public JButton addVehicleButton = new JButton("Add Vehicle");
  public JButton removeVehicleButton = new JButton("Remove Vehicle");

  public JComboBox<String> vehicleListBox;

  public JButton startButton = new JButton("Start all cars");
  public JButton stopButton = new JButton("Stop all cars");

  /* --- Observer stuff --- */
  @Override
  public void actOnWorldChange() {
    drawPanel.repaint();
  }
  /* --- END --- */

  // Constructor
  public CarView(String frameName, ArrayList<ViewEntity> viewEntities) {
    // this.carController = carController;
    this.drawPanel = new DrawPanel(WIDTH + 100, World.HEIGHT, viewEntities);
    initComponents(frameName);
  }

  // Sets everything in place and fits everything
  // TODO: Take a good look and make sure you understand how these methods and components work
  private void initComponents(String title) {
    this.setTitle(title);
    this.setPreferredSize(new Dimension(WIDTH, World.HEIGHT + 240));
    this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

    this.add(drawPanel);

    SpinnerModel spinnerModel =
        new SpinnerNumberModel(
            0, // initial value
            0, // min
            100, // max
            1); // step

    gasSpinner = new JSpinner(spinnerModel);
    gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());

    gasPanel.setLayout(new BorderLayout());
    gasPanel.add(gasLabel, BorderLayout.PAGE_START);
    gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

    this.add(gasPanel);

    String[] modelNames = vehicleTypeNames();
    vehicleListBox = new JComboBox<>(modelNames);
    vehicleListBox.setSelectedIndex(0);

    controlPanel.add(vehicleListBox);

    controlPanel.setLayout(new GridLayout(3, 4));

    controlPanel.add(gasButton, 0);
    controlPanel.add(turboOnButton, 1);
    controlPanel.add(liftBedButton, 2);
    controlPanel.add(brakeButton, 3);
    controlPanel.add(turboOffButton, 4);
    controlPanel.add(lowerBedButton, 5);
    controlPanel.add(removeVehicleButton, 6);
    controlPanel.add(addVehicleButton, 7);
    controlPanel.setPreferredSize(new Dimension((WIDTH / 2) + 4, 200));
    this.add(controlPanel);
    controlPanel.setBackground(Color.CYAN);

    startButton.setBackground(Color.blue);
    startButton.setForeground(Color.green);
    startButton.setPreferredSize(new Dimension(WIDTH / 5 - 15, 200));
    this.add(startButton);

    stopButton.setBackground(Color.red);
    stopButton.setForeground(Color.black);
    stopButton.setPreferredSize(new Dimension(WIDTH / 5 - 15, 200));
    this.add(stopButton);

    // Make the frame pack all it's components by respecting the sizes if possible.
    this.pack();

    // Get the computer screen resolution
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    // Center the frame
    this.setLocation(
        dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    // Make the frame visible
    this.setVisible(true);
    // Make sure the frame exits when "x" is pressed
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private String[] vehicleTypeNames() {
    List<String> vehicleList =
        Arrays.stream(VehicleFactory.VehicleType.values())
            .map(Enum::name)
            .collect(Collectors.toList());
    String[] vehicleStringArr = new String[vehicleList.size()];
    vehicleList.toArray(vehicleStringArr);
    return vehicleStringArr;
  }
}
