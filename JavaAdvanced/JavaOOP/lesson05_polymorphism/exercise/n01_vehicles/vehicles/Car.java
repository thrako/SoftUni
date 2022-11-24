package lesson05_polymorphism.exercise.n01_vehicles.vehicles;

public class Car extends AirConditionedVehicle {

    private final static double AC_CONSUMPTION = 0.9;

    public Car(double fuelQty, double fuelConsumptionPerKm) {
        super(fuelQty, fuelConsumptionPerKm, AC_CONSUMPTION);
    }

}
