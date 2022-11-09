package lesson04_methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class N08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        double result = mathPower(number, power);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double mathPower(double number, int power) {

            return Math.pow(number, power);

    }
}
