package practice_past_exams.fin.exam02_20200809_regular;

import java.util.*;

public class N03PlantDiscovery {
    private static final String END = "Exhibition";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        Map<String, Plant> plants = new LinkedHashMap<>(numLines);
        String[] tokens;
        String name;
        int rarity;
        double rating;
        for (int i = 0; i < numLines; i++) {
            tokens = scanner.nextLine().split("<->");
            name = tokens[0];
            rarity = Integer.parseInt(tokens[1]);
            plants.putIfAbsent(name, new Plant(name));
            plants.get(name).setRarity(rarity);
        }

        String[] subTokens;
        tokens = scanner.nextLine().split(":");
        Plant plant;
        while (!END.equals(tokens[0])) {
            subTokens = tokens[1].trim().split(" - ");
            switch (tokens[0]) {
                case "Rate":
                    name = subTokens[0];
                    rating = Double.parseDouble(subTokens[1]);
                    plant = plants.get(name);
                    if (plant != null) plant.addRating(rating);
                    else System.out.println("error");
                    break;
                case "Update":
                    name = subTokens[0];
                    rarity = Integer.parseInt(subTokens[1]);
                    plant = plants.get(name);
                    if (plant != null) plant.setRarity(rarity);
                    else System.out.println("error");
                    break;
                case "Reset":
                    name = subTokens[0];
                    plant = plants.get(name);
                    if (plant != null) plant.resetRatings();
                    else System.out.println("error");
                    break;
                default:
            }
            tokens = scanner.nextLine().split(":");
        }
        System.out.println("Plants for the exhibition:");
        plants.values().forEach(System.out::println);
    }

    private static class Plant {
        private final String name;
        private int rarity;
        private List<Double> ratings = new ArrayList<>();

        public Plant(String name) {
            this.name = name;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void addRating(double rate) {
            this.ratings.add(rate);
        }

        public void resetRatings() {
            this.ratings = new ArrayList<>();
        }

        @Override
        public String toString() {
            return String.format(
                    "- %s; Rarity: %d; Rating: %.2f",
                    name, rarity, ratings.stream()
                            .mapToDouble(Double::doubleValue)
                            .summaryStatistics()
                            .getAverage()
                    );
        }
    }
}
