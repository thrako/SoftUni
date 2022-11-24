package lesson05_polymorphism.exercise.n01_vehicles.comands;

import lesson05_polymorphism.exercise.n01_vehicles.vehicles.AirConditionedVehicle;

public class RefuelCommand implements Command {
    double quantity;

    public RefuelCommand(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public void executeOn(AirConditionedVehicle vehicle) {
        vehicle.refuel(quantity);
    }
}
