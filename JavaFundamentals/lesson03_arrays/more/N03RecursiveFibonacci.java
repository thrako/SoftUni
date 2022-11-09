package lesson03_arrays.more;

import java.util.Scanner;

public class N03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequentFibonacciNum = Integer.parseInt(scanner.nextLine());
        long fibonacciNum = calcFibonacci(sequentFibonacciNum);
        System.out.println(fibonacciNum);
    }

    private static long calcFibonacci(int seqFibNum) {
        if (seqFibNum <= 0) {
            return 0L;
        } else if (seqFibNum == 1) {
            return 1L;
        } else if (seqFibNum == 2) {
            return 1L;
        } else {
            return calcFibonacci(seqFibNum - 1) + calcFibonacci(seqFibNum - 2);
        }
    }
}
