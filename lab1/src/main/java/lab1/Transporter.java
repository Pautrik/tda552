package lab1;

import java.util.List;

interface Transporter{

  List<Object> getGoods();

  void load(Object object);

  void unload(Object object);
}
