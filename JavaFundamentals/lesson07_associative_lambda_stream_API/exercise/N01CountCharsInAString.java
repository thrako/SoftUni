package lesson07_associative_lambda_stream_API.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        scanner.nextLine().chars()
                .filter(e -> e != 32)
                .mapToObj(e -> (char) e)
                .forEach(e -> charCount.put(e, charCount.containsKey(e)
                        ? charCount.get(e) + 1
                        : 1
                ));
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
