package lesson01_basic_syntax.lab;

import java.util.Scanner;

public class N12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Math.abs(scanner.nextInt());
        while (input % 2 != 0) {
            System.out.println("Please write an even number.");
            input = Math.abs(scanner.nextInt());
        }
        System.out.printf("The number is: %d", input);
    }
}
