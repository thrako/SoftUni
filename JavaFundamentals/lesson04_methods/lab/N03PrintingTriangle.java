package lesson04_methods.lab;

import java.util.Scanner;

public class N03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        printTriangle(1, num);
    }

    private static void printTriangle(int curr, int limit) {
        if (curr == limit) {
            printLineOfNumsTo(curr);
            return;
        }
        printLineOfNumsTo(curr);
        printTriangle(curr + 1, limit);
        printLineOfNumsTo(curr);
    }

    private static void printLineOfNumsTo(int lastNum) {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print (i + " ");
        }
        System.out.println();
    }
}
