package lesson06_defining_classes.exercise.N05CarSalesman;

@SuppressWarnings("FieldMayBeFinal")
class Engine {
    private String model;
    private int power;
    private String displacement = "n/a";
    private String efficiency = "n/a";

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void addDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void addEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s",
                this.model, this.power, this.displacement, this.efficiency);
    }
}
