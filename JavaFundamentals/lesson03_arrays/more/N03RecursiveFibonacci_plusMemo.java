package lesson03_arrays.more;

import java.util.Scanner;

public class N03RecursiveFibonacci_plusMemo {
    public static long[] fibonacciSequence;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nthFibonacciNumber = Integer.parseInt(scanner.nextLine());
        if (nthFibonacciNumber > 0) {
            fibonacciSequence = new long[nthFibonacciNumber + 1];
            fibonacciSequence[0] = 0;
            fibonacciSequence[1] = 1;

            long fibonacciNum = calcFibonacci(nthFibonacciNumber);
            System.out.println(fibonacciNum);
        } else {
            System.out.println(0);
        }
    }

    private static long calcFibonacci(long n) {

        if (n == 0) {
            return 0;
        } else if (fibonacciSequence[(int) n] != 0) {
            return fibonacciSequence[(int) n];
        } else {
            long fibonacciValue = calcFibonacci(n - 1) + calcFibonacci(n - 2);
            fibonacciSequence[(int) n] = fibonacciValue;
            return fibonacciValue;
        }
    }
}
