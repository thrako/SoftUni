package lesson06_objects.more;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N03CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = readEngines(scanner);

        List<Car> cars = readCars(scanner, engines);
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static List<Engine> readEngines(Scanner scanner) {
        int enginesCount = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>(enginesCount);

        for (int i = 0; i < enginesCount; i++) {
            String[] inputs = scanner.nextLine().split("\\s+");
            int counter = -1;
            Engine engine = new Engine(inputs[++counter], inputs[++counter]);
            if (inputs.length == 3) {
                if (isNumeric(inputs[++counter])) {
                    engine.addDisplacement(inputs[counter]);
                } else {
                    engine.addEfficiency(inputs[counter]);
                }
            } else if (inputs.length == 4) {
                engine
                        .addDisplacement(inputs[++counter])
                        .addEfficiency(inputs[++counter]);
            }
            engines.add(engine);
        }
        return engines;
    }

    private static List<Car> readCars(Scanner scanner, List<Engine> engines) {
        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>(carsCount);
        for (int i = 0; i < carsCount; i++) {
            String[] inputs = scanner.nextLine().split("\\s+");
            int counter = -1;
            String carModel = inputs[++counter];
            String engineModel = inputs[++counter];
            Engine carEngine = engines.stream().filter(e -> e.getModel().equals(engineModel)).findAny().orElse(null);
            Car car = new Car(carModel, carEngine);
            if (inputs.length == 3) {
                if (isNumeric(inputs[++counter])) {
                    car.addWeight(inputs[counter]);
                } else {
                    car.addColour(inputs[counter]);
                }
            } else if (inputs.length == 4) {
                car
                        .addWeight(inputs[++counter])
                        .addColour(inputs[++counter]);
            }
            cars.add(car);
        }
        return cars;
    }

    private static boolean isNumeric(String input) {
        return input.matches("[0-9]+");
    }

    private static class Car {
        private final String model;
        private final Engine engine;
        private String weight = "n/a";
        private String colour = "n/a";

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        public Car addWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public Car addColour(String colour) {
            this.colour = colour;
            return this;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s:%n" +
                    "  %s:%n" +
                    "    Power: %s%n" +
                    "    Displacement: %s%n" +
                    "    Efficiency: %s%n" +
                    "  Weight: %s%n" +
                    "  Color: %s",
                    model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), weight, colour
            );
        }
    }

    private static class Engine {
        private final String model;
        private final String power;
        private String displacement = "n/a";
        private String efficiency = "n/a";

        public Engine(String model, String power) {
            this.model = model;
            this.power = power;
        }

        public Engine addDisplacement(String displacement) {
            this.displacement = displacement;
            return this;
        }

        public Engine addEfficiency(String efficiency) {
            this.efficiency = efficiency;
            return this;
        }

        public String getModel() {
            return model;
        }

        public String getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }
    }
}
