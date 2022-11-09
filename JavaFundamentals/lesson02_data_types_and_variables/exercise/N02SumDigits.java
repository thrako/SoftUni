package lesson02_data_types_and_variables.exercise;

import java.util.Scanner;

public class N02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }
        System.out.println(sum);
    }
}
