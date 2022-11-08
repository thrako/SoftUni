package lesson06_defining_classes.exercise.N03SpeedRacing;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        CarRepository fleet = new CarRepository();
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumptionPerKm = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, consumptionPerKm);
            fleet.addCar(car);
        }
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if ("Drive".equals(tokens[0])) {
                try {
                    String model = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    Car car = fleet.getCar(model);
                    if (!car.drive(distance)) System.out.println("Insufficient fuel for the drive");
                } catch (NullPointerException e) {
                    System.out.println("Car not found!");
                }
            }
            input = scanner.nextLine();
        }
        fleet.getCars().values().forEach(System.out::println);
    }
}
