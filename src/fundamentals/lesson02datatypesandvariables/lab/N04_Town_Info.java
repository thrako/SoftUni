package lesson02datatypesandvariables.lab;

import java.util.Scanner;

public class N04_Town_Info {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km.", townName, population, area);
    }
}
