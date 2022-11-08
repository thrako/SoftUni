package lesson03_sets_and_maps_advanced.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class N04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> charCountMap = new TreeMap<>();
        scanner.nextLine().chars()
                .mapToObj(ch -> (char) ch)
                .forEach(ch -> {
                    charCountMap.putIfAbsent(ch, 0);
                    charCountMap.put(ch, charCountMap.get(ch) + 1);
                });
        charCountMap.forEach((ch, count) -> System.out.printf("%s: %d time/s%n", ch, count));
    }
}
