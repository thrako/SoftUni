package lesson06_defining_classes.exercise.N09CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] inputData = input.split("\\s+");
            String breed = inputData[0];
            switch (breed) {
                case "Siamese":
                    cats.add(new Siamese(inputData[1], Double.parseDouble(inputData[2])));
                    break;
                case "Cymric":
                    cats.add(new Cymric(inputData[1], Double.parseDouble(inputData[2])));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(inputData[1], Double.parseDouble(inputData[2])));
                    break;
                default:
                    throw new IllegalStateException("Unsupported breed: " + breed);
            }
            input = scanner.nextLine();
        }
        String catName = scanner.nextLine();
        cats.stream().filter(c -> c.getName().equals(catName)).findFirst().ifPresent(System.out::println);
    }
}
