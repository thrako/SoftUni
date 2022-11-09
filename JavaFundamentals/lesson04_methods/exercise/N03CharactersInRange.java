package lesson04_methods.exercise;

import java.util.Scanner;

public class N03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);
        printCharsInBetween(a, b);
    }

    private static void printCharsInBetween(char a, char b) {
        if (a > b) {
            char temp = a;
            a = b;
            b = temp;
        }
        for (int i = (int) a + 1; i < (int) b; i++) {
            System.out.print((char) (i) + " ");
        }
    }
}
