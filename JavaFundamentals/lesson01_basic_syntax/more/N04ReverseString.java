package lesson01_basic_syntax.more;

import java.util.Scanner;

public class N04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reversedInput = "";

        for (int i = 0; i < input.length(); i++) {
            reversedInput = String.valueOf(input.charAt(i)).concat(reversedInput);
        }

        System.out.println(reversedInput);
    }
}
