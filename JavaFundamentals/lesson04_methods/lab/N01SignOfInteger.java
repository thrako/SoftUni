package lesson04_methods.lab;

import java.util.Scanner;

public class N01SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        printSignOf(num);
    }

    private static void printSignOf(int num) {
        if (num > 0) System.out.printf("The number %d is positive.", num);
        if (num < 0) System.out.printf("The number %d is negative.", num);
        if (num == 0) System.out.print("The number 0 is zero.");
    }
}
