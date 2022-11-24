package lesson05_polymorphism.exercise.n03_wild_farm;

import java.text.DecimalFormat;

public abstract class Animal {

    String animalName;
    String animalType;
    Double animalWeight;
    Integer foodEaten;

    public Animal(String name, String type, Double weight) {
        this.animalName = name;
        this.animalType = type;
        this.animalWeight = weight;
        this.foodEaten = 0;
    }

    abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    public String getFormattedAnimalWeight() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return formatter.format(animalWeight);
    }
}
