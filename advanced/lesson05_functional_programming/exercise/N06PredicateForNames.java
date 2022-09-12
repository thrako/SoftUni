package lesson05_functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class N06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());
        Predicate<String> isInLimit = s -> s.length() <= limit;
        Arrays.stream(scanner.nextLine().split(" "))
                .filter(isInLimit)
                .forEach(System.out::println);
    }
}
