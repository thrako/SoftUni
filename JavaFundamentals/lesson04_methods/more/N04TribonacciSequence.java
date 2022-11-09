package lesson04_methods.more;

import java.util.Scanner;

public class N04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        long[] tribonacciNums = new long[length];
        if (length > 0) tribonacciNums[0] = 1;
        if (length > 1) tribonacciNums[1] = 1;
        if (length > 2) tribonacciNums[2] = 2;
        for (int i = 3; i < length; i++) {
            tribonacciNums[i] = tribonacciNums[i - 1] + tribonacciNums[i - 2] + tribonacciNums[i - 3];
        }
        for (int i = 0; i < length; i++) {
            System.out.print(tribonacciNums[i] + " ");
        }

    }
}
