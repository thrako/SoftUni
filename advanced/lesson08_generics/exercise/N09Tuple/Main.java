package lesson08_generics.exercise.N09Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data;

        data = scanner.nextLine().split("\\s+");
        Tuple<String, String> nameCity = new Tuple<>(data[0].concat(" ").concat(data[1]), data[2]);
        System.out.println(nameCity);

        data = scanner.nextLine().split("\\s+");
        Tuple<String, Integer> nameLiters = new Tuple<>(data[0], Integer.parseInt(data[1]));
        System.out.println(nameLiters);

        data = scanner.nextLine().split("\\s+");
        Tuple<Integer, Double> integerDouble = new Tuple<>(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
        System.out.println(integerDouble);
    }

}
