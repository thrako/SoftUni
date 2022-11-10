package lesson02_encapsulation.exercise.n02_animal_farm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
