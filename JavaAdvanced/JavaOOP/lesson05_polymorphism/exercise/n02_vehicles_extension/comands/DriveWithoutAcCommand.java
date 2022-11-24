package lesson05_polymorphism.exercise.n02_vehicles_extension.comands;

import lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles.AirConditionedVehicle;

public class DriveWithoutAcCommand implements Command {

    double distance;

    public DriveWithoutAcCommand(double distance) {
        this.distance = distance;
    }

    @Override
    public void executeOn(AirConditionedVehicle vehicle) {
        vehicle.driveWithoutAC(distance);
    }
}
