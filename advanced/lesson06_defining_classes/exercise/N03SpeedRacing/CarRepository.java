package lesson06_defining_classes.exercise.N03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;

class CarRepository {
    private final Map<String, Car> cars = new LinkedHashMap<>();


    public void addCar(Car car) {
        this.cars.put(car.getModel(), car);
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public Car getCar(String model) {
        return cars.get(model);
    }
}
