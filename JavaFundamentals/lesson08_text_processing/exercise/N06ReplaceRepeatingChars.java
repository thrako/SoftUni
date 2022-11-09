package lesson08_text_processing.exercise;

import java.util.Scanner;

public class N06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        StringBuilder strBld = new StringBuilder();

        if (length != 0) strBld.append(str.charAt(0));
        for (int i = 1; i < length; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                strBld.append(str.charAt(i));
            }
        }

        System.out.println(strBld);
    }
}
