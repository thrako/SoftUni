package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

import lesson05_polymorphism.exercise.n02_vehicles_extension.exceptions.IllegalRefuelArgumentException;
import lesson05_polymorphism.exercise.n02_vehicles_extension.exceptions.NotEnoughCapacityException;
import lesson05_polymorphism.exercise.n02_vehicles_extension.exceptions.NotEnoughFuelException;

import java.text.DecimalFormat;

public abstract class AirConditionedVehicle {
    private static final String TRAVEL_FORMAT = "%s travelled %s km";
    private static final String NEEDS_REFUEL_FORMAT = "%s needs refueling";
    private static final String REMAINING_FUEL_FORMAT = "%s: %.2f";

    private static final String FUEL_MUST_BE_POSITIVE_MESSAGE = "Fuel must be a positive number";
    private static final String CANNOT_FIT_FUEL_MESSAGE = "Cannot fit fuel in tank";

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.##");

    protected double fuelQty;
    protected double fuelConsumptionPerKm;
    protected double airConditionerConsumptionPerKm;
    protected double tankCapacity;

    protected AirConditionedVehicle(double fuelQty, double fuelConsumptionPerKm, double airConditionerConsumptionPerKm, double tankCapacity) {
        this.fuelQty = fuelQty;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.airConditionerConsumptionPerKm = airConditionerConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    public void driveWithAC(double kilometers) {
        drive(kilometers, fuelConsumptionPerKm + airConditionerConsumptionPerKm);
    }

    public void driveWithoutAC(double kilometers) {
        drive(kilometers, fuelConsumptionPerKm);
    }

    public boolean drive(double distance, double consumption) {
        final double necessaryFuelQty = distance * consumption;
        if (necessaryFuelQty > this.fuelQty) {
            throw new NotEnoughFuelException(String.format(NEEDS_REFUEL_FORMAT, this.getType()));
        }
        this.fuelQty -= necessaryFuelQty;
        this.printTravelMsg(distance);
        return true;
    }

    public void refuel(double addedFuelQty) {
        if (addedFuelQty <= 0) {

            throw new IllegalRefuelArgumentException(FUEL_MUST_BE_POSITIVE_MESSAGE);
        }
        if (fuelQty + addedFuelQty > tankCapacity) {
            throw new NotEnoughCapacityException(CANNOT_FIT_FUEL_MESSAGE);
        }
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
