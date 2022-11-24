package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

public class Bus extends AirConditionedVehicle {
    private final static double AC_CONSUMPTION = 1.4;

    public Bus(double fuelQty, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQty, fuelConsumptionPerKm, AC_CONSUMPTION, tankCapacity);
    }
}
