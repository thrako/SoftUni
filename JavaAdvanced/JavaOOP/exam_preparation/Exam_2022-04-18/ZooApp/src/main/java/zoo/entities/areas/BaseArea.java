package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {
    
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;
    
    protected BaseArea(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }
    
    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }
    
    @Override
    public int sumCalories() {
        return this.foods.stream()
                .mapToInt(Food::getCalories)
                .sum();
    }
    
    @Override
    public void addAnimal(Animal animal) {
        if (this.animals.size() >= capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
    
        this.animals.add(animal);
    }
    
    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }
    
    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }
    
    @Override
    public void feed() {
        this.animals.forEach(Animal::eat);
    }
    
    @Override
    public String getInfo() {
        StringBuilder strBld = new StringBuilder();
        String newLine = System.lineSeparator();
    
        return strBld
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                    .append(newLine)
                .append(String.format("Animals: %s", getAnimalNames()))
                    .append(newLine)
                .append(String.format("Foods: %s", this.foods.size()))
                    .append(newLine)
                .append(String.format("Calories: %d", sumCalories()))
                .toString();
        
        
    }
    
    private String getAnimalNames() {
        return animals.isEmpty() ? "none" : animals.stream().map(Animal::getName).collect(Collectors.joining(" "));
    }
}
