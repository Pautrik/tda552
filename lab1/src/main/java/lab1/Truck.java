package lab1;

import java.awt.*;
import java.util.List;

public abstract class Truck extends Car implements Transporter{

  private List<Object> goods;

  Truck() {
    numberOfDoors = 2;
    color = Color.white;
    enginePower = 80;
    modelName = "Scania730";
    stopEngine();
  }

  @Override
  public List<Object> getGoods() {
    return goods;
  }

  @Override
  public void load(Object object) {
    goods.add(object);
  }

  @Override
  public void unload(Object object) {
    goods.remove(object);
  }
}
