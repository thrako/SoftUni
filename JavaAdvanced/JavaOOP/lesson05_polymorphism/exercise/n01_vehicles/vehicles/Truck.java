package lesson05_polymorphism.exercise.n01_vehicles.vehicles;

public class Truck extends AirConditionedVehicle {
    private final static double AC_CONSUMPTION = 1.6;
    private final static double FUEL_LEAKAGE = 0.05;

    public Truck(double fuelQty, double fuelConsumptionPerKm) {
        super(fuelQty, fuelConsumptionPerKm, AC_CONSUMPTION);
    }

    @Override
    public void refuel(double addedFuelQty) {
        super.refuel(addedFuelQty * (1 - FUEL_LEAKAGE));
    }
}
