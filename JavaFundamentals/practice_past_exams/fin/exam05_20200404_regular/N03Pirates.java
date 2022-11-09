package practice_past_exams.fin.exam05_20200404_regular;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N03Pirates {
    public static void main(String[] args) {
        Map<String, City> cities = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        consoleRead(cities, scanner);
        executeConsoleCommands(cities, scanner);
        printResults(cities);
    }

    private static void consoleRead(Map<String, City> cities, Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\|\\|");
        while (!"Sail".equals(tokens[0])) {
            String name = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            cities.putIfAbsent(name, new City(name, 0, 0));
            cities.get(name).increasePopulation(population).increaseGold(gold);

            tokens = scanner.nextLine().split("\\|\\|");
        }
    }

    private static void executeConsoleCommands(Map<String, City> cities, Scanner scanner) {
        String[] tokens = scanner.nextLine().split("=>");
        while (!"End".equals(tokens[0])) {
            switch (tokens[0]) {
                case "Plunder": {
                    String name = tokens[1];
                    int killedPeople = Integer.parseInt(tokens[2]);
                    int stolenGold = Integer.parseInt(tokens[3]);

                    City city = cities.get(name);
                    plunder(city, killedPeople, stolenGold);
                    if (city.isDisbanded()) {
                        System.out.printf("%s has been wiped off the map!%n", city.getName());
                        cities.remove(city.getName());
                    }
                    break;
                }
                case "Prosper": {
                    String name = tokens[1];
                    int gold = Integer.parseInt(tokens[2]);

                    cities.get(name).prosper(gold);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + tokens[0]);
            }

            tokens = scanner.nextLine().split("=>");
        }
    }

    private static void printResults(Map<String, City> cities) {
        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",
                    cities.size());
            for (City city : cities.values()) {
                System.out.println(city);
            }
        }
    }

    private static void plunder(City city, int killedPeople, int stolenGold) {
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                city.getName(), stolenGold, killedPeople);
        city.decreasePopulation(killedPeople);
        city.decreaseGold(stolenGold);
    }

    private static class City {
        private final String name;
        private int population = 0;
        private int gold = 0;


        public City(String name, int population, int gold) {

            this.name = name;
            this
                    .increaseGold(gold)
                    .increasePopulation(population);
        }

        public String getName() {
            return name;
        }

        public City increasePopulation(int population) {
            this.population += population;
            return this;
        }

        public void decreasePopulation(int killedPeople) {
            this.population -= killedPeople;
        }

        public City increaseGold(int gold) {
            this.gold += gold;
            return this;
        }

        public void decreaseGold(int stolenGold) {
            this.gold -= stolenGold;
        }

        public void prosper(int addedGold) {
            if (addedGold < 0) {
                System.out.println("Gold added cannot be a negative number!");
            } else {
                this.gold += addedGold;
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                        addedGold, this.name, this.gold);
            }
        }

        private boolean isDisbanded() {
            return this.population <= 0 || this.gold <= 0;
        }

        @Override
        public String toString() {
            return String.format("%s -> Population: %d citizens, Gold: %d kg",
                    this.name, this.population, this.gold);
        }
    }

}
