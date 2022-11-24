package lesson05_polymorphism.exercise.n01_vehicles.comands;

import lesson05_polymorphism.exercise.n01_vehicles.vehicles.AirConditionedVehicle;

public class DriveWithAcCommand implements Command {

    double distance;

    public DriveWithAcCommand(double distance) {
        this.distance = distance;
    }

    @Override
    public void executeOn(AirConditionedVehicle vehicle) {
        vehicle.driveWithAC(distance);
    }
}
