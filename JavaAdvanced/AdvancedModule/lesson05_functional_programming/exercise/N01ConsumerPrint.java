package lesson05_functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class N01ConsumerPrint {
    public static void main(String[] args) {
        Consumer<String> print = System.out::println;
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(print);
    }
}
