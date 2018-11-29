package lab3.model;

import java.awt.geom.Point2D;

public class ViewEntity implements Positionable{

    private String name;
    private Point2D position;

    public ViewEntity(String name, Point2D position) {
        this.position = position;
        this.name = name;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
