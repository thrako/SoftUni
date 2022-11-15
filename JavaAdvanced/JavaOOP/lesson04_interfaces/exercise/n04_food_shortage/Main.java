package lesson04_interfaces.exercise.n04_food_shortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Map<String, Buyer> buyers = new HashMap<>();

        int peopleCount = Integer.parseInt(scanner.nextLine());

        String consoleLine;
        while (peopleCount-- > 0) {
            consoleLine = scanner.nextLine();
            String[] lineParts = consoleLine.split("\\s+");
            switch (lineParts.length) {
                case 4: {
                    addNewCitizen(buyers, lineParts);
                    break;
                }
                case 3: {
                    addNewRebel(buyers, lineParts);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected count of arguments: " + lineParts.length);
            }
        }

        consoleLine = scanner.nextLine();
        while (!"End".equals(consoleLine)) {
            Buyer buyer = buyers.get(consoleLine);
            if (buyer != null) {
                buyer.buyFood();
            }
            consoleLine = scanner.nextLine();
        }

        Integer totalFoodBought = buyers.values().stream()
                .map(Buyer::getFood)
                .reduce(Integer::sum).orElse(0);
        System.out.println(totalFoodBought);
    }

    private static void addNewCitizen(Map<String, Buyer> people, String[] lineParts) {
        final String name = lineParts[0];
        final int age = Integer.parseInt(lineParts[1]);
        final String id = lineParts[2];
        final String birthDate = lineParts[3];
        final Buyer buyer = new Citizen(name, age, id, birthDate);
        people.put(name, buyer);
    }

    private static void addNewRebel(Map<String, Buyer> people, String[] lineParts) {
        String name = lineParts[0];
        int age = Integer.parseInt(lineParts[1]);
        String group = lineParts[2];
        final Buyer buyer = new Rebel(name, age, group);
        people.put(name, buyer);
    }

}
