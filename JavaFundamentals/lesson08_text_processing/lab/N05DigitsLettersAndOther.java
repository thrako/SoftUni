package lesson08_text_processing.lab;

import java.util.Scanner;

public class N05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();
        String input = scanner.nextLine();
        for (int i = 0, length = input.length(); i < length; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) digits.append(ch);
            else if (Character.isAlphabetic(ch)) letters.append(ch);
            else others.append(ch);
        }
        System.out.printf("%s%n%s%n%s%n", digits, letters, others);

    }
}
