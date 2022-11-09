package lesson07_associative_lambda_stream_API.lab;

import java.util.*;
import java.util.stream.Collectors;

public class N03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> words = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::toLowerCase)
                .forEach(e -> words.put(e, words.get(e) == null ? 1 : words.get(e) + 1));

        List<String> result = words.entrySet().stream()
                .filter(e -> e.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", result));
    }
}
