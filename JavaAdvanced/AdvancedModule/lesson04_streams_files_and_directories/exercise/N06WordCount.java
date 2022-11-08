package lesson04_streams_files_and_directories.exercise;

import java.io.*;
import java.util.*;

public class N06WordCount {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(Resources.PATH.concat("words.txt")));
        Map<String, Integer> occurances = new HashMap<>();

        while (scanner.hasNext()) {
            occurances.put(scanner.next(), 0);
        }

        scanner = new Scanner(new FileReader(Resources.PATH.concat("text.txt")));
        while (scanner.hasNext()) {
            String word = scanner.next();
            occurances.keySet().stream()
                    .filter(key -> key.equals(word))
                    .findFirst()
                    .ifPresent(key -> occurances.put(key, occurances.get(key) + 1));
        }
        scanner.close();

        PrintWriter writer = new PrintWriter(new FileWriter(Resources.PATH.concat("results.txt")));
        occurances.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(String.format("%s - %d", entry.getKey(), entry.getValue())));
        writer.close();
    }
}
