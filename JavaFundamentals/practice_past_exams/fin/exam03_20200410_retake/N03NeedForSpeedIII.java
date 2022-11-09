package practice_past_exams.fin.exam03_20200410_retake;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N03NeedForSpeedIII {
    private static final String END = "Stop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>(numCars);
        for (int i = 0; i < numCars; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String name = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            cars.putIfAbsent(name, new Car(name, mileage, fuel));
        }

        String[] tokens = scanner.nextLine().split(" : ");
        while (!END.equals(tokens[0])) {
            String command = tokens[0];
            String name = tokens[1];
            Car car = cars.get(name);
            switch (command) {
                case "Drive": {
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    car.drive(distance, fuel);
                    car.checkMileage(cars);
                }
                break;
                case "Refuel": {
                    int fuel = Integer.parseInt(tokens[2]);
                    car.refill(fuel);
                }
                break;
                case "Revert": {
                    int km = Integer.parseInt(tokens[2]);
                    car.revert(km);
                }
                break;
                default:
            }
            tokens = scanner.nextLine().split(" : ");
        }

        cars.values().forEach(System.out::println);
    }

    private static class Car {
        private static final int MILEAGE_MAX = 100_000;
        private static final int MILEAGE_MIN = 10_000;
        private static final int TANK_CAP = 75;
        private final String name;
        private int mileage;
        private int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public void drive(int distance, int fuelConsumed) {
            if (this.fuel < fuelConsumed) {
                System.out.println("Not enough fuel to make that ride");
                return;
            }
            this.mileage += distance;
            this.fuel -= fuelConsumed;
            System.out.printf(
                    "%s driven for %d kilometers. %d liters of fuel consumed.%n",
                    this.name, distance, fuelConsumed);
        }

        private void checkMileage(Map<String, Car> cars) {
            if (this.mileage > MILEAGE_MAX) {
                System.out.printf("Time to sell the %s!%n", this.name);
                cars.remove(this.name);
            }
        }

        public void refill(int fuel) {
            int refilledFuel = Math.min(TANK_CAP - this.fuel, fuel);
            this.fuel += refilledFuel;
            System.out.printf(
                    "%s refueled with %d liters%n",
                    this.name, refilledFuel);
        }

        public void revert(int kilometers) {
            this.mileage -= kilometers;
            if (this.mileage >= MILEAGE_MIN) {
                System.out.printf(
                        "%s mileage decreased by %d kilometers%n",
                        this.name, kilometers);
            } else {
                this.mileage = MILEAGE_MIN;
            }
        }

        @Override
        public String toString() {
            return String.format(
                    "%s -> Mileage: %d kms, Fuel in the tank: %d lt.",
                    this.name, this.mileage, this.fuel);
        }
    }
}
