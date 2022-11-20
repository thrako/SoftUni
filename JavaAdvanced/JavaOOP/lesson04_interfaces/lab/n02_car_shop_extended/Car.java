package lesson04_interfaces.lab.n02_car_shop_extended;

import java.io.Serializable;

public interface Car extends Serializable {

    int TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();

}
