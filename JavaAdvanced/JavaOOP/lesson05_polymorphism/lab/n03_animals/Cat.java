package lesson05_polymorphism.lab.n03_animals;

public class Cat extends Animal {

    public Cat(String name, String favFood) {
        super(name, favFood);
    }

    @Override
    protected String explainSelf() {
        return super.toString() + System.lineSeparator() + "MEEOW";
    }
}
