package helpers.combinatorics;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        long result;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of available objects: ");
        int n = Integer.parseInt(scanner.nextLine());

        if (n < 1) {
            System.out.println("Invalid number of available objects!");
        } else {
            result = factorial(n);

            System.out.print("Number of objects to take: ");
            int k = Integer.parseInt(scanner.nextLine());
            if (k > n || k < 0) {
                System.out.println("Invalid input! The number of objects to take should be positive and may not exceed the number of available objects.");
            } else if (k != 0) {
                result /= factorial(n - k);

                System.out.print("Does order matter? (Y/N): ");
                if (!scanner.nextLine().equalsIgnoreCase("y")) {
                    result /= factorial(k);
                }
            } else {
                result = 0;
            }
            System.out.println("--------------------------------------------");
            System.out.println("The number of possibilities is: " + result);
        }

    }

    private static long factorial(int n) {
        long number = 1;
        while (n > 0) {
            number *= n;
            n--;
        }
        return number;
    }
}
