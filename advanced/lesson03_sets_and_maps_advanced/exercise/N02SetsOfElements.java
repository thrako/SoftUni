package lesson03_sets_and_maps_advanced.exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class N02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();
        int[] inputsCount = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < inputsCount[0]; i++) {
            setOne.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < inputsCount[1]; i++) {
            setTwo.add(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println(setOne.stream()
                .filter(setTwo::contains)
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
