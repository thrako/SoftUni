package lesson08_text_processing.lab;

import java.util.Scanner;

public class N02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder strBld = new StringBuilder();
        String[] words = scanner.nextLine().split("\\s+");
        for (String word : words) {
            strBld.append(word.repeat(word.length()));
        }
        System.out.println(strBld);
    }
}
