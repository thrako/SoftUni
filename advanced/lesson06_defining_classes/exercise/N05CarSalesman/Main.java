package lesson06_defining_classes.exercise.N05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EngineRepository engines = getEngines(scanner);
        List<Car> cars = getCars(scanner, engines);
        cars.forEach(System.out::println);
    }

    private static EngineRepository getEngines(Scanner scanner) {
        EngineRepository engines = new EngineRepository();
        int enginesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < enginesCount; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            Engine engine = new Engine(model, power);
            if (engineData.length == 3) {
                if (isNumeric(engineData[2])) {
                    String displacement = engineData[2];
                    engine.addDisplacement(displacement);
                } else {
                    String efficiency = engineData[2];
                    engine.addEfficiency(efficiency);
                }
            }
            if (engineData.length == 4) {
                String displacement = engineData[2];
                engine.addDisplacement(displacement);
                String efficiency = engineData[3];
                engine.addEfficiency(efficiency);
            }
            engines.add(engine);
        }
        return engines;
    }

    private static List<Car> getCars(Scanner scanner, EngineRepository engines) {
        List<Car> cars = new ArrayList<>();
        int carsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carsCount; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            var model = carData[0];
            var engine = engines.get(carData[1]);
            Car car = new Car(model, engine);
            if (carData.length == 3) {
                if (isNumeric(carData[2])) {
                    String weight = carData[2];
                    car.addWeight(weight);
                } else {
                    String color = carData[2];
                    car.addColor(color);
                }
            }
            if (carData.length == 4) {
                String weight = carData[2];
                car.addWeight(weight);
                String color = carData[3];
                car.addColor(color);
            }
            cars.add(car);
        }
        return cars;
    }

    private static boolean isNumeric(String string) {
        return string.chars()
                .mapToObj(i -> (char) i)
                .allMatch(Character::isDigit);
    }

}
