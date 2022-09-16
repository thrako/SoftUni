package lesson06_defining_classes.exercise.N04RawData;

@SuppressWarnings("FieldCanBeLocal")
class Tire {
    private final double pressure;
    private final int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }
}
