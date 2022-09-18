package lesson06_defining_classes.exercise.N09CatLady;

class Siamese extends Cat {
    private final double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", super.getName(), this.earSize);
    }
}
