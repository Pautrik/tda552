package lab.model;

import lab.model.vehicles.*;
import lab.model.vehicles.Vehicle;


public class VehicleFactory {

  public enum VehicleType {
    VOLVO {
      @Override
      public Vehicle create(int x, int y){
        return new Volvo240(x, y);
      }
    },
    SAAB{
      @Override
      public Vehicle create(int x, int y) {
        return new Saab95(x, y);
      }
    },
    SCANIA{
      @Override
      public Vehicle create(int x, int y) {
        return new Scania(x, y);
      }
    };
    public abstract Vehicle create(int x, int y);
  }

  public Vehicle makeVehicle(VehicleType type, int x, int y){
    return type.create(x, y);
  }
}
