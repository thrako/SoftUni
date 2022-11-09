package lesson06_objects.more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N02RawData {
    private static final double MIN_PRESSURE = 1;
    private static final int MAX_POWER = 250;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = consoleFill(scanner);

        String keyword = scanner.nextLine();
        switch (keyword) {
            case "fragile":
                cars.stream()
                        .filter(car -> car.getCargo().getType().equals(keyword))
                        .filter(car -> Arrays.stream(car.getTyres())
                                .anyMatch(tyre -> tyre.getPressure() < MIN_PRESSURE))
                        .forEach(c -> System.out.println(c.getModel()));
                break;

            case "flamable": //typo in design
                cars.stream()
                        .filter(car -> car.getCargo().getType().equals(keyword))
                        .filter(car -> car.getEngine().getPower() > MAX_POWER)
                        .forEach(c -> System.out.println(c.getModel()));
                break;
        }
    }

    private static List<Car> consoleFill(Scanner scanner) {
        int carsCount = Integer.parseInt(scanner.nextLine());
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
            cars.add(new Car(model, engine, cargo, tyres));
        }
        return cars;
    }

    private static class Car {
        private final String model;
        private final Engine engine;
        private final Cargo cargo;
        private final Tyre[] tyres;

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

        public int getPower() {
            return power;
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

        public double getPressure() {
            return pressure;
        }
    }
}
