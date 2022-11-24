package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

public class Car extends AirConditionedVehicle {

    private final static double AC_CONSUMPTION = 0.9;

    public Car(double fuelQty, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQty, fuelConsumptionPerKm, AC_CONSUMPTION, tankCapacity);
    }

}
