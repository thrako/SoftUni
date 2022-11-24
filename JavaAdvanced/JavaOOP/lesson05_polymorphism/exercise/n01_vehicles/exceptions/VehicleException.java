package lesson05_polymorphism.exercise.n01_vehicles.exceptions;

 public abstract class VehicleException extends RuntimeException {
    protected VehicleException(String message) {
        super(message);
    }
}
