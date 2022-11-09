package lesson04_methods.exercise;

import java.util.Scanner;

public class N05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int result = subtract(sum(first, second), third);
        System.out.println(result);
    }

    private static int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    private static int sum(int augend, int addend) {
        return augend + addend;
    }
}
