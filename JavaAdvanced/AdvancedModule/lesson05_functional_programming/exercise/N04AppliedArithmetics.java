package lesson05_functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class N04AppliedArithmetics {
    public static void main(String[] args) {
        Function<Integer[], Integer[]> add = arr -> {
            for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
                arr[i] += 1;
            }
            return arr;
        };

        Function<Integer[], Integer[]> multiply = arr -> {
            for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
                arr[i] *= 2;
            }
            return arr;
        };


        Function<Integer[], Integer[]> subtract = arr -> {
            for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
                arr[i] -= 1;
            }
            return arr;
        };

        Consumer<Integer[]> print = arr -> System.out.println(
                Arrays.stream(arr)
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );


        Scanner scanner = new Scanner(System.in);
        Integer[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            switch (input) {
                case "add":
                    add.apply(arr);
                    break;
                case "multiply":
                    multiply.apply(arr);
                    break;
                case "subtract":
                    subtract.apply(arr);
                    break;
                case "print":
                    print.accept(arr);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
            input = scanner.nextLine();
        }
        //print.accept(arr);

    }
}
