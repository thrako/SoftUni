package lesson05_polymorphism.lab.n03_animals;

public abstract class Animal {
    private final String name;
    private final String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected abstract String explainSelf();

    @Override
    public String toString() {
        return String.format("I am %s and my favourite food is %s", name, favouriteFood);
    }
}
