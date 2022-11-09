package lesson06_objects.lab;

import java.util.Random;
import java.util.Scanner;

public class N01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        Random rnd = new Random();
        randomize(words, rnd);
        printEachOnNewLine(words);
    }

    private static void randomize(String[] words, Random rnd) {
        int length = words.length;
        for (int i = 0; i < length; i++) {
            swap(words, i, rnd.nextInt(length));
        }
    }

    private static void printEachOnNewLine(String[] words) {
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static void swap(String[] words, int idx, int random) {
        if (idx != random) {
            String temp = words[idx];
            words[idx] = words[random];
            words[random] = temp;
        }
    }
}
