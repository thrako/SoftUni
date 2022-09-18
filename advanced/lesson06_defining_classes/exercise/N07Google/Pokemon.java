package lesson06_defining_classes.exercise.N07Google;

class Pokemon {
    private final String name;
    private final String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.type);
    }
}
