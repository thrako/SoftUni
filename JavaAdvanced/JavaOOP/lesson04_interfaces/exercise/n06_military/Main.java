package lesson04_interfaces.exercise.n06_military;

import java.util.Scanner;

public class Main {

    private static final String END = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Army army = new Army();
        String consoleLine = scanner.nextLine();
        while (!END.equals(consoleLine)) {
            final String[] tokens = consoleLine.split(" ");
            army.add(tokens);
            consoleLine = scanner.nextLine();
        }

        army.getSoldiers().forEach(System.out::println);
    }
}
