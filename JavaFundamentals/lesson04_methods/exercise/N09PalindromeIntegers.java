package lesson04_methods.exercise;

import java.util.Scanner;

public class N09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));
            input = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String input) {
        return input.equals(reverse(input));
    }

    private static String reverse(String input) {
        String reversed = "";
        for (int i = 0, length = input.length(); i < length; i++) {
            char ch = input.charAt(i);
            reversed = ch + reversed;
        }
        return reversed;
    }
}
