package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int number = input;
        int sum = 0;
        while (number / 10 != 0) {
            int digit = number % 10;
            sum += calcFactorial(digit);
            number /= 10;
        }
        sum += calcFactorial(number % 10);

        System.out.println((input == sum) ? "yes" : "no");
    }

    private static int calcFactorial(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
