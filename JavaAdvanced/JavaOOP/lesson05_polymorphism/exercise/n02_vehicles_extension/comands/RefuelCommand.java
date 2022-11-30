package lesson05_polymorphism.exercise.n02_vehicles_extension.comands;

import lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles.AirConditionedVehicle;

public class RefuelCommand implements Command {

    private final double quantity;

    public RefuelCommand(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public void executeOn(AirConditionedVehicle vehicle) {
        vehicle.refuel(quantity);
    }
}
