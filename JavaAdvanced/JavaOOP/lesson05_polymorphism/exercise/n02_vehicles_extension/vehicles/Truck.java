package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

public class Truck extends AirConditionedVehicle {

    private final static double AC_CONSUMPTION = 1.6;
    private final static double FUEL_LEAKAGE = 0.05;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, AC_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double addedFuelQuantity) {
        super.refuel(addedFuelQuantity * (1 - FUEL_LEAKAGE));
    }
}
