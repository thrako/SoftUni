package lesson04_methods.exercise;

import java.util.Scanner;

public class N08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        double quotient = factorialDivision(first, second);
        System.out.printf("%.2f", quotient);
    }

    private static double factorialDivision(int dividend, int divisor) {
        return (double) factorialOf(dividend) / (double) factorialOf(divisor);
    }

    private static long factorialOf(int number) {
        if (number >= 0) {
            long factorial = 1;
            for (int i = number; i > 1; i--) {
                factorial *= i;
            }
            return factorial;
        } else {
            System.out.println("Factorial is not defined for negative numbers!");
            return 0;
        }
    }
}
