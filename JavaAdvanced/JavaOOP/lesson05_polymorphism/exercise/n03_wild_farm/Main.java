package lesson05_polymorphism.exercise.n03_wild_farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String END = "End";
    private static String consoleLine;

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        updateConsoleLine(scanner);
        while (!END.equals(consoleLine)) {

            final Animal animal = getAnimal(consoleLine);
            animals.add(animal);

            updateConsoleLine(scanner);
            final Food food = getFood(consoleLine);

            animal.makeSound();

            tryFeeding(animal, food);

            updateConsoleLine(scanner);
        }

        animals.forEach(System.out::println);

    }

    private static void updateConsoleLine(Scanner scanner) {
        consoleLine = scanner.nextLine();
    }

    private static Animal getAnimal(String consoleLine) {
        final String[] animalData = consoleLine.split("\\s+");
        final String type = animalData[0];
        final String name = animalData[1];
        final double weight = Double.parseDouble(animalData[2]);
        final String livingRegion = animalData[3];
        Animal animal = null;
        switch (type) {
            case "Mouse":
                animal = new Mouse(name, type, weight, livingRegion);
                break;
            case "Cat":
                final String breed = animalData[4];
                animal = new Cat(name, type, weight, livingRegion, breed);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, livingRegion);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, livingRegion);
                break;
        }
        return animal;
    }

    private static Food getFood(String consoleLine) {
        final String[] foodData = consoleLine.split("\\s+");
        final String type = foodData[0];
        final int quantity = Integer.parseInt(foodData[1]);
        Food food = null;
        switch (type) {
            case "Meat":
                food = new Meat(quantity);
                break;
            case "Vegetable":
                food = new Vegetable(quantity);
                break;
        }
        return food;
    }

    private static void tryFeeding(Animal animal, Food food) {
        try {
            animal.eat(food);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
