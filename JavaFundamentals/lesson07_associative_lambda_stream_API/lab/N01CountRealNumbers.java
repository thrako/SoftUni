package lesson07_associative_lambda_stream_API.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class N01CountRealNumbers {
    public static void main(String[] args) {
        Map<Double, Integer> duplicates = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> duplicates.put(e, duplicates.containsKey(e) ? duplicates.get(e) + 1 : 1));

        DecimalFormat decFormatter = new DecimalFormat("#.####");
        duplicates.forEach((key, value) -> System.out.printf("%s -> %d%n", decFormatter.format(key), value));
    }
}
