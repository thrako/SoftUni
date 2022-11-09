package lesson06_objects.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N06VehicleCatalog {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input = scanner.nextLine();

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            vehicles.add(new Vehicle(tokens));
            updateInput();
        }
        while (!"Close the Catalogue".equals(input)) {
            vehicles.stream().filter(e -> e.getModel().equals(input)).forEach(System.out::print);
            updateInput();
        }

        int truckTotalHP, truckCounter, carTotalHP, carCounter;
        truckTotalHP = truckCounter = carTotalHP = carCounter = 0;
        for (Vehicle vehicle : vehicles) {
            switch (vehicle.getType()) {
                case "Truck":
                    truckTotalHP += vehicle.getHorsepower();
                    truckCounter++;
                    break;
                case "Car":
                    carTotalHP += vehicle.getHorsepower();
                    carCounter++;
                    break;
            }
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n",
                (carCounter != 0)
                    ? (double) carTotalHP / carCounter
                    : 0
        );
        System.out.printf("Trucks have average horsepower of: %.2f.%n",
                (truckCounter != 0)
                    ? (double) truckTotalHP / truckCounter
                    : 0
        );
    }

    private static void updateInput() {
        input = scanner.nextLine();
    }

    private static class Vehicle {
        private final String type;
        private final String model;
        private final String color;
        private final int horsepower;

        public Vehicle(String[] args) {
            this.type = args[0].substring(0,1).toUpperCase() + args[0].substring(1).toLowerCase();
            this.model = args[1];
            this.color = args[2];
            this.horsepower = Integer.parseInt(args[3]);
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public int getHorsepower() {
            return horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %d%n", this.type, this.model, this.color, this.horsepower);
        }
    }
}
