package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

public class Truck extends AirConditionedVehicle {
    private final static double AC_CONSUMPTION = 1.6;
    private final static double FUEL_LEAKAGE = 0.05;

    public Truck(double fuelQty, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQty, fuelConsumptionPerKm, AC_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double addedFuelQty) {
        super.refuel(addedFuelQty * (1 - FUEL_LEAKAGE));
    }
}
