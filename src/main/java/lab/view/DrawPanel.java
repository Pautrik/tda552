package lab.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import lab.model.ViewEntity;

// ** This panel represent the animated part of the view with the car images. */
public class DrawPanel extends JPanel {

  private ArrayList<ViewEntity> viewEntities;

  public DrawPanel(int x, int y, ArrayList<ViewEntity> viewEntities) {
    this.viewEntities = viewEntities;
    this.setDoubleBuffered(true);
    this.setPreferredSize(new Dimension(x, y));
    this.setBackground(Color.green);
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    for (ViewEntity viewEntity : viewEntities) {
      switch (viewEntity.getName()) {
        case "Volvo240":
          graphics.drawImage(
              viewEntity.getImage(), viewEntity.getPosition().x, viewEntity.getPosition().y, null);
          break;
        case "Saab95":
          graphics.drawImage(
              viewEntity.getImage(), viewEntity.getPosition().x, viewEntity.getPosition().y, null);
          break;
        case "Scania":
          graphics.drawImage(
              viewEntity.getImage(), viewEntity.getPosition().x, viewEntity.getPosition().y, null);
          break;
      }
    }
  }
}
