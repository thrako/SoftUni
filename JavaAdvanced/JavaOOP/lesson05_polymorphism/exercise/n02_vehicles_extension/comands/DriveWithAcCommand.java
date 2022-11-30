package lesson05_polymorphism.exercise.n02_vehicles_extension.comands;

import lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles.AirConditionedVehicle;

public class DriveWithAcCommand implements Command {

    private final double distance;

    public DriveWithAcCommand(double distance) {
        this.distance = distance;
    }

    @Override
    public void executeOn(AirConditionedVehicle vehicle) {
        vehicle.driveWithAC(distance);
    }
}
