package lesson04_interfaces.exercise.n03_birthday_celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> creatures = new ArrayList<>();

        String consoleLine = scanner.nextLine();
        while (!"End".equals(consoleLine)) {
            Birthable birthable;
            String[] lineParts = consoleLine.split("\\s+");
            String type = lineParts[0];
            switch (type) {
                case "Citizen": {
                    String name = lineParts[1];
                    int age = Integer.parseInt(lineParts[2]);
                    String id = lineParts[3];
                    String birthDate = lineParts[4];
                    birthable = new Citizen(name, age, id, birthDate);
                    break;
                }
                case "Robot": {
                    consoleLine = scanner.nextLine();
                    continue;
                }
                case "Pet": {
                    String name = lineParts[1];
                    String birthDate = lineParts[2];
                    birthable = new Pet(name, birthDate);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unsupported type: " + type);
            }

            creatures.add(birthable);
            consoleLine = scanner.nextLine();
        }

        String soughtYear = scanner.nextLine();
        creatures.stream()
                .map(Birthable::getBirthDate)
                .filter(bd -> bd.endsWith(soughtYear))
                .forEach(System.out::println);
    }
}


