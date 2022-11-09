package lesson01_basic_syntax.lab;

import java.util.Scanner;

public class N03PassedOrFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        if (grade > 2.99) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
