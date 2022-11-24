package lesson05_polymorphism.exercise.n01_vehicles.vehicles;

import java.util.function.BiFunction;

public enum AirConditionedVehicleFactory {
    Car(lesson05_polymorphism.exercise.n01_vehicles.vehicles.Car::new),
    Truck(lesson05_polymorphism.exercise.n01_vehicles.vehicles.Truck::new)
    ;

    private final BiFunction<Double, Double, AirConditionedVehicle> aNew;

    AirConditionedVehicleFactory(BiFunction<Double, Double, AirConditionedVehicle> aNew) {
        this.aNew = aNew;
    }

    public static AirConditionedVehicle construct(String type, double fuel, double consumption) {
        return AirConditionedVehicleFactory.valueOf(type).aNew.apply(fuel, consumption);
    }

}
