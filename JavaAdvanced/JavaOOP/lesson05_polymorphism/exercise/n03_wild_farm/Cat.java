package lesson05_polymorphism.exercise.n03_wild_farm;

public class Cat extends Feline {

    String breed;

    public Cat(String name, String type, double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(Messages.CAT_SOUND);
    }

    @Override
    public String toString() {

        return String.format(Messages.CAT_FORMAT,
                animalType, animalName, breed, getFormattedAnimalWeight(), livingRegion, foodEaten);
    }
}
