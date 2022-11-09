package lesson02_data_types_and_variables.exercise;

import java.util.Scanner;

public class N04SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < num; i++) {
            int symbAscii = scanner.nextLine().charAt(0);
            sum += symbAscii;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
