package lesson06objects.more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N02RawData {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = readInputs(scanner, carsCount);
        List<Car> filteredCars = new ArrayList<>();
        String keyword = scanner.nextLine();
        if ("fragile".equals(keyword)) {
            int minPressure = 1;
            filteredCars = findFragile(cars, minPressure);
        } else if ("flamable".equals(keyword)) { //typo in design
            int maxPower = 250;
            filteredCars = findFlammable(cars, maxPower);
        }

        if (filteredCars.size() > 0) {
            printModels(filteredCars);
        }
    }

    private static void printModels(List<Car> filteredCars) {
        for (Car filteredCar : filteredCars) {
            System.out.println(filteredCar.getModel());
        }
    }

    private static List<Car> readInputs(Scanner scanner, int carsCount) {
        List<Car> cars = new ArrayList<>(carsCount);
        for (int i = 0; i < carsCount; i++) {
            String[] inputs = scanner.nextLine().split("\\s+");
            int counter = 0;
            String model = inputs[counter++];
            Engine engine = new Engine(
                    Integer.parseInt(inputs[counter++]),
                    Integer.parseInt(inputs[counter++])
            );
            Cargo cargo = new Cargo(
                    Integer.parseInt(inputs[counter++]),
                    inputs[counter++]
            );
            Tyre[] tyres = new Tyre[4];
            for (int j = 0; j < 4; j++) {
                Tyre tyre = new Tyre(
                        Double.parseDouble(inputs[counter++]),
                        Integer.parseInt(inputs[counter++])
                );
                tyres[j] = tyre;
            }
            cars.add(new Car(
                    model, engine, cargo, tyres
            ));
        }
        return cars;
    }

    private static List<Car> findFragile(List<Car> cars, int minPressure) {
        return cars.stream()
                .filter(car -> car.getCargo().getType().equals("fragile"))
                .filter(car -> Arrays.stream(car.getTyres())
                        .anyMatch(tyre -> !tyre.hasEnoughPressure(minPressure)))
                .collect(Collectors.toList());
    }

    private static List<Car> findFlammable(List<Car> cars, int maxPower) {
        return cars.stream()
                .filter(car -> car.getCargo().getType().equals("flamable"))
                .filter(car -> car.getEngine().exceedsMaxPower(maxPower))
                .collect(Collectors.toList());
    }

    private static class Car {
        private final String model;
        private final Engine engine;
        private final Cargo cargo;
        private Tyre[] tyres;

        public Car(String model, Engine engine, Cargo cargo, Tyre[] tyres) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tyres = tyres;
        }

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public Tyre[] getTyres() {
            return tyres;
        }
    }

    private static class Engine {
        private final int speed;
        private final int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public boolean exceedsMaxPower(int maxPower) {
            return power > maxPower;
        }
    }

    private static class Cargo {
        private final int weight;
        private final String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private static class Tyre {
        private final double pressure;
        private final int age;

        public Tyre(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public boolean hasEnoughPressure(int minPressure) {
            return this.pressure >= minPressure;
        }
    }
}
