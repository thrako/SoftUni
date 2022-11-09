package lesson04_methods.exercise;

import java.util.Scanner;

public class N10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= num; i++) {
            if (sumOfDigits(i) % 8 == 0 && hasAtLeastOneOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static boolean hasAtLeastOneOddDigit(int number) {
        while (number > 0) {
            if (number % 2 != 0) {
                return true;
            } else {
                number /= 10;
            }
        }
        return false;
    }
}
