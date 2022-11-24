package lesson05_polymorphism.exercise.n03_wild_farm;

public class Tiger extends Feline {

    public Tiger(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(Messages.TIGER_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)) {
            throw new IllegalArgumentException(String.format(Messages.NOT_EATING_THAT_FOOD, "Tigers"));
        }
        super.eat(food);
    }
}
