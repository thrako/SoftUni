package lesson06_defining_classes.lab.N02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < linesCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car;
            if (tokens.length < 3) {
                car = new Car(tokens[0]);
            } else {
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.getInfo());
        }
    }
}
