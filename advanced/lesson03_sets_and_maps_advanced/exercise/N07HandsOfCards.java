package lesson03_sets_and_maps_advanced.exercise;

import java.util.*;

public class N07HandsOfCards {
    private static final Map<String, Integer> powers = new HashMap<>();
    private static final Map<String, Integer> types = new HashMap<>();
    private static final Map<String, Set<String>> players = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        setPowers();
        setTypes();
        String input = scanner.nextLine();
        while (!"JOKER".equals(input)) {
            String[] inputData = input.split(": ");
            String name = inputData[0];
            String[] cards = inputData[1].split(", ");
            players.putIfAbsent(name, new HashSet<>());
            for (String card : cards) {
                players.get(name).add(card);
            }
            input = scanner.nextLine();
        }

        for (var entry : players.entrySet()) {
            int sum = 0;
            for (String card : entry.getValue()) {
                sum += calculate(card);
            }
            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }
    }

    private static void setPowers() {
        powers.put("2", 2);
        powers.put("3", 3);
        powers.put("4", 4);
        powers.put("5", 5);
        powers.put("6", 6);
        powers.put("7", 7);
        powers.put("8", 8);
        powers.put("9", 9);
        powers.put("10", 10);
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);
    }

    private static void setTypes() {
        types.put("S", 4);
        types.put("H", 3);
        types.put("D", 2);
        types.put("C", 1);
    }

    private static Integer calculate(String card) {
        return powers.get(card.substring(0, card.length() - 1)) * types.get(card.substring(card.length() - 1));
    }
}
