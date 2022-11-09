package lesson04_methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class N11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double operand = Double.parseDouble(scanner.nextLine());
        String operation = scanner.nextLine();
        double operator = Double.parseDouble(scanner.nextLine());
        double result = calculate(operand, operator, operation);
        System.out.println(new DecimalFormat("0.##").format(result));
    }

    private static double calculate(double operand, double operator, String operation) {
        switch (operation) {
            case "+":
                return operand + operator;
            case "-":
                return operand - operator;
            case "*":
                return operand * operator;
            case "/":
                return operand / operator;
            case "%":
                return operand % operator;
            default:
                System.out.println("Unsupported operation");
                return 0;
        }
    }
}
