package lesson06_defining_classes.lab.N01CarInfo;

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
            Car car = new Car();
            car.setBrand(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsePower(Integer.parseInt(tokens[2]));
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.getInfo());
        }
    }
}
