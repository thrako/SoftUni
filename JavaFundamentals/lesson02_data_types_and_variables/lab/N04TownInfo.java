package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N04TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km.", townName, population, area);
    }
}
