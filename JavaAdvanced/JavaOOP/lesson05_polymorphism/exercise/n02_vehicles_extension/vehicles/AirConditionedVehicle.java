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

    protected double fuelQuantity;
    protected double fuelConsumptionPerKm;
    protected double AcConsumptionPerKm;
    protected double tankCapacity;

    protected AirConditionedVehicle(double fuelQuantity,
                                    double fuelConsumptionPerKm,
                                    double AcConsumptionPerKm,
                                    double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.AcConsumptionPerKm = AcConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    public void driveWithAC(double distance) {
        drive(distance, fuelConsumptionPerKm + AcConsumptionPerKm);
    }

    public void driveWithoutAC(double distance) {
        drive(distance, fuelConsumptionPerKm);
    }

    public void drive(double distance, double consumption) {
        final double necessaryFuelQuantity = distance * consumption;

        if (necessaryFuelQuantity > this.fuelQuantity) {
            throw new NotEnoughFuelException(String.format(NEEDS_REFUEL_FORMAT, this.getType()));
        }

        this.fuelQuantity -= necessaryFuelQuantity;
        this.printTravelMsg(distance);
    }

    public void refuel(double addedFuelQuantity) {
        if (addedFuelQuantity <= 0) {
            throw new IllegalRefuelArgumentException(FUEL_MUST_BE_POSITIVE_MESSAGE);
        }

        if (fuelQuantity + addedFuelQuantity > tankCapacity) {
            throw new NotEnoughCapacityException(CANNOT_FIT_FUEL_MESSAGE);
        }

        this.fuelQuantity += addedFuelQuantity;
    }

    public String getRemainingFuelMessage() {
        return String.format(REMAINING_FUEL_FORMAT, this.getType(), this.fuelQuantity);
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    private void printTravelMsg(double distance) {
        System.out.printf((TRAVEL_FORMAT + "%n"), this.getType(), decimalFormat.format(distance));
    }
}
