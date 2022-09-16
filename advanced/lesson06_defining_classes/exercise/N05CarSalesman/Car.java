package lesson06_defining_classes.exercise.N05CarSalesman;

@SuppressWarnings("FieldMayBeFinal")
class Car {
    private String model;
    private Engine engine;
    private String weight = "n/a";
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void addWeight(String weight) {
        this.weight = weight;
    }

    public void addColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s%nWeight: %s%nColor: %s",
                this.model, this.engine, this.weight, this.color);
    }
}
