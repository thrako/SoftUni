package lesson05_polymorphism.exercise.n01_vehicles.vehicles;

import lesson05_polymorphism.exercise.n01_vehicles.exceptions.NotEnoughFuelException;

import java.text.DecimalFormat;

public abstract class AirConditionedVehicle {
    private static final String TRAVEL_FORMAT = "%s travelled %s km";
    private static final String NEEDS_REFUEL_FORMAT = "%s needs refueling";
    private static final String REMAINING_FUEL_FORMAT = "%s: %.2f";

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.##");

    protected double fuelQty;
    protected double fuelConsumptionPerKm;
    protected double airConditionerConsumptionPerKm;

    protected AirConditionedVehicle(double fuelQty, double fuelConsumptionPerKm, double airConditionerConsumptionPerKm) {
        this.fuelQty = fuelQty;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.airConditionerConsumptionPerKm = airConditionerConsumptionPerKm;
    }

    public void driveWithAC(double kilometers) {
        drive(kilometers, fuelConsumptionPerKm + airConditionerConsumptionPerKm);
    }

    public void drive(double distance, double consumption) {
        final double necessaryFuelQty = distance * consumption;
        if (necessaryFuelQty > this.fuelQty) {
            throw new NotEnoughFuelException(String.format(NEEDS_REFUEL_FORMAT, this.getType()));
        }
        this.fuelQty -= necessaryFuelQty;
        this.printTravelMsg(distance);
    }

    public void refuel(double addedFuelQty) {
        this.fuelQty += addedFuelQty;
    }

    public String getRemainingFuelMessage() {
        return String.format(REMAINING_FUEL_FORMAT, this.getType(), this.fuelQty);
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    private void printTravelMsg(double distance) {
        System.out.printf((TRAVEL_FORMAT + "%n"), this.getType(), decimalFormat.format(distance));
    }
}
