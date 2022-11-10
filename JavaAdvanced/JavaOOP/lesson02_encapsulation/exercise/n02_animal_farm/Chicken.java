package lesson02_encapsulation.exercise.n02_animal_farm;

public class Chicken {
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 15;
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
    }

    private void setAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE) throw new IllegalArgumentException("Age should be between 0 and 15.");
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age <= 5)     return 2;
        else if (age <= 11)    return 1;
        else                   return 0.75;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }
}
