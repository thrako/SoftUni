package lesson05_functional_programming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
