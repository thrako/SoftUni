package lesson03_sets_and_maps_advanced.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> doubleCountMap = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(d -> {
                    int value = doubleCountMap.getOrDefault(d, 0);
                    doubleCountMap.put(d, value + 1);
                });
        for (Map.Entry<Double, Integer> entry : doubleCountMap.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(), entry.getValue());
        }
    }
}
