package lesson05_polymorphism.exercise.n02_vehicles_extension.exceptions;

 public abstract class VehicleException extends RuntimeException {

    protected VehicleException(String message) {
        super(message);
    }

}
