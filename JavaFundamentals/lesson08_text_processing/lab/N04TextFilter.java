package lesson08_text_processing.lab;

import java.util.Scanner;

public class N04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(",\\s+");
        String filtered = scanner.nextLine();
        for (String bannedWord : bannedWords) {
            String replacement = "*".repeat(bannedWord.length());
            filtered = filtered.replace(bannedWord, replacement);
        }
        System.out.println(filtered);
    }
}
