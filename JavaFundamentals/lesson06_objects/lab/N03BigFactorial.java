package lesson06_objects.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class N03BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(factorialOf(number));
    }

    private static BigInteger factorialOf(int number) {
        BigInteger sum = BigInteger.ONE;
        for (int i = number; i >= 2; i--) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        return sum;
    }
}
