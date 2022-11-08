package lesson03_sets_and_maps_advanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class N01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputsCount = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueStrings = new LinkedHashSet<>();
        for (int i = 0; i < inputsCount; i++) {
            uniqueStrings.add(scanner.nextLine());
        }

        uniqueStrings.forEach(System.out::println);
    }
}
