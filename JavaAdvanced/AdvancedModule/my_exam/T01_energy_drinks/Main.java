package my_exam.T01_energy_drinks;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int MAX_CAFFEINE_LIMIT = 300;
    private static int caffeineLevel = 0;
    private static Deque<Integer> miligrams;
    private static Queue<Integer> drinks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        readMiligrams(scanner);
        readDrinks(scanner);
        processEnergyDrinks();
        printResults();

    }

    private static void readMiligrams(Scanner scanner) {
        miligrams = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(miligrams::push);
    }

    private static void readDrinks(Scanner scanner) {
        drinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(drinks::offer);
    }

    private static void processEnergyDrinks() {
        while (!miligrams.isEmpty() && !drinks.isEmpty()) {
            int mg = miligrams.pop();
            //noinspection ConstantConditions
            int drink = drinks.poll();
            int energyDrink = mg * drink;
            if (caffeineLevel + energyDrink > MAX_CAFFEINE_LIMIT) {
                refuse(drink);
            } else {
                accept(energyDrink);
            }
        }
    }

    private static void printResults() {
        if (drinks.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.printf("Drinks left: %s%n", drinks.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineLevel);
    }

    private static void refuse(Integer drink) {
        drinks.offer(drink);
        caffeineLevel = Math.max(caffeineLevel - 30, 0);
    }

    private static void accept(Integer energyDrink) {
        caffeineLevel += energyDrink;
    }
}
