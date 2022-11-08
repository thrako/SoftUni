package lesson06_defining_classes.exercise.N09CatLady;

class Cymric extends Cat {
    private final double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", super.getName(), this.furLength);
    }
}
