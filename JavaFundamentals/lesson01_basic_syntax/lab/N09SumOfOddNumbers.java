package lesson01_basic_syntax.lab;

import java.util.Scanner;

public class N09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int counter = 0;
        int number = 1;
        while (counter < n) {
            System.out.println(number);
            sum += number;
            number += 2;
            counter++;
        }
        System.out.printf("Sum: %d", sum);
    }
}
