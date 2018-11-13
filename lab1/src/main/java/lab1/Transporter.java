package src.main.java.lab1;

import java.util.List;

public interface Transporter{
  public List<Object> getGoods();

  public void load(Object object);

  public void unload(Object object);
}
