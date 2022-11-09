package lesson08_text_processing.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(", "))
                .filter(str -> str.length() >= 3
                        && str.length() <= 16
                        && str.matches("^[A-Za-z0-9_-]*$"))
                .forEach(System.out::println);
    }
}
