package lesson01_basic_syntax.lab;

import java.util.Scanner;

public class N02Passed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        if (grade >= 3) {
            System.out.println("Passed!");
        }
    }
}
