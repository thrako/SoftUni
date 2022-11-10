package lesson02_encapsulation.exercise.n04_pizza_calories;

import java.util.HashMap;
import java.util.Map;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private final Map<String, Double> flourModifiers = new HashMap<>();
    private final Map<String, Double> techniqueModifiers = new HashMap<>();


    public Dough(String flourType, String bakingTechnique, double weight) {
        flourModifiers.put("White", 1.5);
        flourModifiers.put("Wholegrain", 1.0);
        techniqueModifiers.put("Crispy", 0.9);
        techniqueModifiers.put("Chewy", 1.1);
        techniqueModifiers.put("Homemade", 1.0);
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourModifiers.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!techniqueModifiers.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return weight * 2 * flourModifiers.get(flourType) * techniqueModifiers.get(bakingTechnique);
    }
}
