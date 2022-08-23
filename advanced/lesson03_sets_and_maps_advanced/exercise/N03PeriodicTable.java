package lesson03_sets_and_maps_advanced.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class N03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputsCount = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < inputsCount; i++) {
            elements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }
        System.out.println(String.join(" ", elements));
    }
}
