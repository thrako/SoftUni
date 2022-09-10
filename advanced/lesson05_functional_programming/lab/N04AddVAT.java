package lesson05_functional_programming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class N04AddVAT {
    public static void main(String[] args) {
        UnaryOperator<Double> addVat = number -> number * 1.2;
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println("Prices with VAT:");
        Arrays.stream(input.split(",\\s+"))
                .map(Double::parseDouble)
                .map(addVat)
                .map(d -> String.format("%.2f", d))
                .forEach(System.out::println);
    }
}
