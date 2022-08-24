package lesson03_sets_and_maps_advanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] inputData = input.split("\\|");
            String city = inputData[0];
            String country = inputData[1];
            long population = Long.parseLong(inputData[2]);
            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);
            input = scanner.nextLine();
        }

        countries.entrySet().stream()
                .sorted((e1, e2) -> getTotalPopulation(e2.getValue()).compareTo(getTotalPopulation(e1.getValue())))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), getTotalPopulation(entry.getValue()));
                    entry.getValue().entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });

    }

    private static Long getTotalPopulation(Map<String, Long> cityPopulation) {
        return cityPopulation.values().stream().reduce(Long::sum).orElse(0L);
    }
}
