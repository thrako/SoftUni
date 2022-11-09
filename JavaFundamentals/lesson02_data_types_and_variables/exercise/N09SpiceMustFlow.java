package lesson02_data_types_and_variables.exercise;

import java.util.Scanner;

public class N09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currYield = Integer.parseInt(scanner.nextLine());
        int minedSpice = 0;
        int counter = 0;
        int workersConsumption = 26;

        while (currYield >= 100) {
            minedSpice += currYield;
            if (minedSpice >= workersConsumption) {
                minedSpice -= workersConsumption;
            } else {
                minedSpice = 0;
            }
            currYield -= 10;
            counter++;
        }
        if (minedSpice >= workersConsumption) {
            minedSpice -= workersConsumption;
        } else {
            minedSpice = 0;
        }
        System.out.println(counter);
        System.out.println(minedSpice);
    }
}
