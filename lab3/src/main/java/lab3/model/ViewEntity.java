package lab3.model;


import java.awt.*;

public class ViewEntity implements Positionable{

    private String name;
    private Point position;

    public ViewEntity(String name, Point position) {
        this.position = position;
        this.name = name;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
