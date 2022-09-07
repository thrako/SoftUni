package lesson05_functional_programming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class N02SumNumbers {
    public static void main(String[] args) {
        Function<String, Integer> sum = string -> Arrays.stream(string.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .sum();
        Function<String, Integer> count = string -> string.split(",\\s+").length;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.printf("Count = %d%n", count.apply(input));
        System.out.printf("Sum = %d%n", sum.apply(input));
    }
}
