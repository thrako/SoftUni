package lesson02_encapsulation.exercise.n04_pizza_calories;

import java.util.HashMap;
import java.util.Map;

public class Topping {
    private String toppingType;
    private double weight;
    private final Map<String, Double> toppingModifiers = new HashMap<>();

    public Topping(String toppingType, double weight) {
        toppingModifiers.put("Meat", 1.2);
        toppingModifiers.put("Veggies", 0.8);
        toppingModifiers.put("Cheese", 1.1);
        toppingModifiers.put("Sauce", 0.9);
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingModifiers.containsKey(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return weight * 2 * toppingModifiers.get(toppingType);
    }
}
