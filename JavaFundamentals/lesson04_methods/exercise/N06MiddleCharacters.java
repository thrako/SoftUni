package lesson04_methods.exercise;

import java.util.Scanner;

public class N06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printMiddleChars(input);
    }

    private static void printMiddleChars(String input) {
        int length = input.length();
        if (length > 0) {
            if (length % 2 == 0) {
                int mid1 = length / 2 - 1;
                int mid2 = length / 2;
                System.out.print(input.charAt(mid1));
                System.out.print(input.charAt(mid2));
            } else {
                int mid = length / 2;
                System.out.print(input.charAt(mid));
            }
        }
    }
}
