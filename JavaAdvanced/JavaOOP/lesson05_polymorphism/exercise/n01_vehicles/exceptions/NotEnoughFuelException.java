package lesson05_polymorphism.exercise.n01_vehicles.exceptions;

public class NotEnoughFuelException extends VehicleException {

    public NotEnoughFuelException(String message) {
        super(message);
    }

}
