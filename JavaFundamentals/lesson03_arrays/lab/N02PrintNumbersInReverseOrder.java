package lesson03_arrays.lab;

import java.util.Scanner;

public class N02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = length - 1; i > -1 ; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
