package lesson01_stacks_and_queues.exercise;

import java.util.Scanner;

public class N06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nth = Integer.parseInt(scanner.nextLine());
        if (nth == 0 || nth == 1) {
            System.out.println(1);
        } else {
            long[] fibonacci = new long[nth];
            System.out.println(getFibonacci(nth, fibonacci));
        }
    }

    private static long getFibonacci(int number, long[] fibonacci) {
        if (number == 0 || number == 1) {
            fibonacci[number] = 1;
            return 1;
        }

        if (fibonacci[number - 1] == 0) {
            fibonacci[number - 1] = getFibonacci(number - 1, fibonacci);
        }
        if (fibonacci[number - 2] == 0) {
            fibonacci[number - 2] = getFibonacci(number - 2, fibonacci);
        }
        return fibonacci[number - 1] + fibonacci[number - 2];
    }
}
