package lesson04_methods.exercise;

import java.util.Scanner;

public class N07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printNxNMatrixOf(n);
    }

    private static void printNxNMatrixOf(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) System.out.printf("%d ", n);
                else System.out.printf("%d", n);
            }
            if (i < n - 1) System.out.println();
        }
    }
}
