package lesson06_defining_classes.exercise.N07Google;

class Car {
    private final String model;
    private final String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.model, this.speed);
    }
}
