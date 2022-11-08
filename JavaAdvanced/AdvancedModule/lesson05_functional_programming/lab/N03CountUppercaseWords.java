package lesson05_functional_programming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class N03CountUppercaseWords {
    public static void main(String[] args) {
        Predicate<String> isUppercase = string -> Character.isUpperCase(string.charAt(0));
        Function<String, List<String>> toListUpperCase = string -> Arrays.stream(string.split("\\s+"))
                .filter(isUppercase)
                .collect(Collectors.toList());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> listUpper = toListUpperCase.apply(input);
        System.out.println(listUpper.size());
        listUpper.forEach(System.out::println);
    }
}
