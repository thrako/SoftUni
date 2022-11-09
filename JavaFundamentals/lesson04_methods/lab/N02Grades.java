package lesson04_methods.lab;

import java.util.Scanner;

public class N02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        printInWords(grade);
    }

    private static void printInWords(double grade) {
        if (grade < 2 || 6 < grade) {
            System.out.println("Not valid grade");
        } else if (grade < 3) {
            System.out.println("Fail");
        } else if (grade < 3.5) {
            System.out.println("Poor");
        } else if (grade < 4.5) {
            System.out.println("Good");
        } else if (grade < 5.5) {
            System.out.println("Very good");
        } else if (grade <= 6) {
            System.out.println("Excellent");
        }

    }
}
