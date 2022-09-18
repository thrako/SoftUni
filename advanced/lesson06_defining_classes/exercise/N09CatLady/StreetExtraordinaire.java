package lesson06_defining_classes.exercise.N09CatLady;

class StreetExtraordinaire extends Cat {
    private final double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", super.getName(), this.decibelsOfMeows);
    }
}
