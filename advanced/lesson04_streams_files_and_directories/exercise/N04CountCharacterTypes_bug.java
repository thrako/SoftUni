package lesson04_streams_files_and_directories.exercise;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class N04CountCharacterTypes_bug {
    private static final Map<String, Integer> TYPE_COUNT = new LinkedHashMap<>();
    private static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');
    private static final List<Character> CAPITAL_VOWELS = List.of('A', 'E', 'I', 'O', 'U');
    private static final List<Character> PUNCTUATION = List.of('!', ',', '.', '?');

    public static void main(String[] args) throws IOException {
        TYPE_COUNT.put("Vowels", 0);
        TYPE_COUNT.put("Consonants", 0);
        TYPE_COUNT.put("Punctuation", 0);

        BufferedReader reader = new BufferedReader(new FileReader(Resources.PATH.concat("input.txt")));
        reader.lines()
                .map(String::toCharArray)
                .forEach(N04CountCharacterTypes_bug::count);

        FileWriter writer = new FileWriter(Resources.PATH.concat("output.txt"));

        TYPE_COUNT.forEach((key, value) -> {
            try {
                writer.write(String.format("%s: %s%n", key, value));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        reader.close();
        writer.close();
    }

    private static void increment(String key) {
        TYPE_COUNT.put(key, TYPE_COUNT.get(key) + 1);
    }

    private static void count(char[] chars) {
        for (var ch : chars) {
            if (Character.isLetter(ch)) {
                if (VOWELS.contains(ch)) increment("Vowels");
                else if (CAPITAL_VOWELS.contains(ch)) System.out.printf("Should we count this as a consonant? --> %s%n", ch);
                else increment("Consonants");
            } else if (PUNCTUATION.contains(ch)) {
                increment("Punctuation");
            } else if (!Character.isWhitespace(ch)) {
                System.out.printf("Should we count this as a consonant? --> %s%n", ch);
            }
        }
    }
}