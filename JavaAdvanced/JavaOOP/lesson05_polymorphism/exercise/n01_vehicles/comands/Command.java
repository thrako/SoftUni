package lesson05_polymorphism.exercise.n01_vehicles.comands;

import lesson05_polymorphism.exercise.n01_vehicles.vehicles.AirConditionedVehicle;

@FunctionalInterface
public interface Command {

    void executeOn(AirConditionedVehicle vehicle);

}
