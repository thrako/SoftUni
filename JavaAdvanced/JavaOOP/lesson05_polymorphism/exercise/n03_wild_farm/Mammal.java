package lesson05_polymorphism.exercise.n03_wild_farm;

public abstract class Mammal extends Animal {
    String livingRegion;

    public Mammal(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format(Messages.MAMMAL_FORMAT,
                animalType, animalName, getFormattedAnimalWeight(), livingRegion, foodEaten);
    }
}
