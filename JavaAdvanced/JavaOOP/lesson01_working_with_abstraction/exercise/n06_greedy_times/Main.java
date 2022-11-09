package lesson01_working_with_abstraction.exercise.n06_greedy_times;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(capacity);

        String[] safe = scanner.nextLine().split("\\s+");

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);

            String type = "useless";
            if (name.length() == 3) type = "Cash";
            else if (name.toLowerCase().endsWith("gem")) type = "Gem";
            else if (name.equalsIgnoreCase("gold")) type = "Gold";

            if (!"useless".equals(type)) bag.addItem(type, name, quantity);
        }
        bag.printContents();
    }
}