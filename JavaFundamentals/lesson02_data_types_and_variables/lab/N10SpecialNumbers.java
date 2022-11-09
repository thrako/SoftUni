package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            int j = i;
            int sum = 0;

            while (j/10 > 0) {
                sum += j%10;
                j /= 10;
            }
            sum += j%10;

            String special = (sum == 5 || sum == 7 || sum == 11) ? "True" : "False";
            System.out.printf("%d -> %s%n", i, special);
        }
    }
}
