package lesson05_polymorphism.exercise.n03_wild_farm;

public class Zebra extends Mammal {

    public Zebra(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(Messages.ZEBRA_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            throw new IllegalArgumentException(String.format(Messages.NOT_EATING_THAT_FOOD, "Zebras"));
        }
        super.eat(food);
    }
}
