package lesson03_inheritance.exercise.n05_restaurant;

import java.math.BigDecimal;

public class Soup extends Starter {
    public Soup(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
