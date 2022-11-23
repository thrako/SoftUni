package lesson05_polymorphism.lab.n03_animals;

public class Dog extends Animal {

    public Dog(String name, String favFood) {
        super(name, favFood);
    }

    @Override
    protected String explainSelf() {
        return super.toString() + System.lineSeparator() + "DJAAF";
    }

}
