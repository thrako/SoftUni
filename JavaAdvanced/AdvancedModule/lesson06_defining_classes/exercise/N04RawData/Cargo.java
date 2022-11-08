package lesson06_defining_classes.exercise.N04RawData;

@SuppressWarnings("FieldCanBeLocal")
class Cargo {
    private final int weight;
    private final String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
