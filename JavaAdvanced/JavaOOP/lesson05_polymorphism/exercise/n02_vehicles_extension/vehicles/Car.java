package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

public class Car extends AirConditionedVehicle {

    private final static double AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, AC_CONSUMPTION, tankCapacity);
    }

}
