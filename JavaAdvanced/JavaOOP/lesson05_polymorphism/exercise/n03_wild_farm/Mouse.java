package lesson05_polymorphism.exercise.n03_wild_farm;

public class Mouse extends Mammal {

    public Mouse(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(Messages.MOUSE_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            throw new IllegalArgumentException(String.format(Messages.NOT_EATING_THAT_FOOD, "Mice"));
        }
        super.eat(food);
    }
}
