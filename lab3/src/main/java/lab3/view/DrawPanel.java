package lab3.view;

import lab3.controller.CarController;
import lab3.model.ViewEntity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    private BufferedImage vehicleImage;

    ArrayList<ViewEntity> viewEntities;

//     To keep track of a single cars position
//    private Point vehiclePoint = new Point();
//
//     TODO: Make this general for all cars
//    public void moveit(int x, int y){
//        vehiclePoint.x = x;
//        vehiclePoint.y = y;
//    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<ViewEntity> viewEntities) {
        this.viewEntities = viewEntities;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try { vehicleImage = ImageIO.read(new File("./src/main/java/lab3/res/pics/Volvo240.jpg")); }
        catch (IOException ex) { ex.printStackTrace(); }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ViewEntity ve : viewEntities) {
            // see javadoc for more info on the parameters
            g.drawImage(vehicleImage, ve.getPosition().x, ve.getPosition().y, null);
        }
    }
}
