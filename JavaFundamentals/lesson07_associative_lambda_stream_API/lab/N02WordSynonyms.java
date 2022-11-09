package lesson07_associative_lambda_stream_API.lab;

import java.util.*;

public class N02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> dictionary = new LinkedHashMap<>();

        int numWords = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numWords; i++) {
            String key = scanner.nextLine();
            String val = scanner.nextLine();
            dictionary.putIfAbsent(key, new ArrayList<>());
            dictionary.get(key).add(val);
        }

        for (Map.Entry<String, List<String>> word : dictionary.entrySet()) {
            String synonyms = String.join(", ", word.getValue());
            System.out.printf("%s - %s%n", word.getKey(), synonyms);
        }

    }
}
