package lesson05_polymorphism.exercise.n02_vehicles_extension.comands;

import lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles.AirConditionedVehicle;

@FunctionalInterface
public interface Command {

    void executeOn(AirConditionedVehicle vehicle);

}
