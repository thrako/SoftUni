package lesson08_text_processing.exercise;

import java.util.Scanner;

public class N04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int length = input.length();
        StringBuilder strBld = new StringBuilder();
        for (int i = 0; i < length; i++) {
            strBld.append(Character.toString(input.charAt(i) + 3));
        }
        System.out.println(strBld);
    }
}
