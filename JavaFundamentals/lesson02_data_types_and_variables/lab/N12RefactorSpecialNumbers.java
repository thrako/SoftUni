package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {

            int sum = 0;
            int j = i;

            while (j > 0) {
                sum += j % 10;
                j = j / 10;
            }

            String isSpecial = (sum == 5) || (sum == 7) || (sum == 11) ? "True" : "False";
            System.out.printf("%d -> %s%n", i, isSpecial);
        }
    }
}
