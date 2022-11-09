package lesson04_methods.lab;

import java.util.Scanner;

public class N04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        int operand = Integer.parseInt(scanner.nextLine());
        int operator = Integer.parseInt(scanner.nextLine());
        switch (operation) {
            case "add":
                add(operand, operator);
                break;
            case "multiply":
                multiply(operand, operator);
                break;
            case "subtract":
                substract(operand, operator);
                break;
            case "divide":
                divide(operand, operator);
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    private static void add(int operand, int operator) {
        System.out.println(operand + operator);
    }

    private static void substract(int operand, int operator) {
        System.out.println(operand - operator);
    }

    private static void multiply(int operand, int operator) {
        System.out.println((operand * operator));
    }

    private static void divide(int operand, int operator) {
        if (operand % operator == 0) {
            System.out.println(operand / operator);
        } else {
            System.out.println((double) operand / operator);
        }
    }
}
