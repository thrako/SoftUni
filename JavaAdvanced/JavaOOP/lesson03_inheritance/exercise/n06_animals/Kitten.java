package lesson03_inheritance.exercise.n06_animals;

public class Kitten extends Cat {
    private static final String KITTENS_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, KITTENS_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
