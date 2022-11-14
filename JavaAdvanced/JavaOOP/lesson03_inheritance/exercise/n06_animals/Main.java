package lesson03_inheritance.exercise.n06_animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();

        while (!"Beast!".equals(firstLine)) {
            String[] secondLine = scanner.nextLine().split("\\s+");
            try {
                Animal animal = createAnimal(firstLine, secondLine);
                animals.add(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            firstLine = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static Animal createAnimal(String type, String... data ) {
        Animal animal;
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        String gender;

        switch (type) {
            case "Dog":
                gender = data[2];
                animal = new Dog(name, age, gender);
                break;
            case "Cat":
                gender = data[2];
                animal = new Cat(name, age, gender);
                break;
            case "Frog":
                gender = data[2];
                animal = new Frog(name, age, gender);
                break;
            case "Kittens":
                animal = new Kitten(name, age);
                break;
            case "Tomcat":
                animal = new Tomcat(name, age);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return animal;
    }
}
