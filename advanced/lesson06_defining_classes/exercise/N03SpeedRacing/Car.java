package lesson06_defining_classes.exercise.N03SpeedRacing;

class Car {
    private final String model;
    private double fuel;
    private final double consumptionPerKm;
    private int odometer = 0;

    public Car(String model, double fuel, double consumptionPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.consumptionPerKm = consumptionPerKm;
    }

    public String getModel() {
        return this.model;
    }

    public boolean drive(Integer distance) {
        if (this.fuel < distance * this.consumptionPerKm) return false;
        this.fuel -= distance * this.consumptionPerKm;
        this.odometer += distance;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.odometer);
    }
}
