package lesson03_inheritance.exercise.n05_restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {
    private final double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
