package lesson04_methods.exercise;

import java.util.Scanner;

public class N02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        printVowelsNumberOf(word);
    }

    private static void printVowelsNumberOf(String word) {
        int counter = 0;
        for (int i = 0, length = word.length(); i < length; i++) {
            if (isVowel(word.charAt(i))) counter++;
        }
        System.out.println(counter);
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
