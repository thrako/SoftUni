package lesson02datatypesandvariables.lab;

import java.util.Scanner;

public class N02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rate = 1.36;
        double pounds = Double.parseDouble(scanner.nextLine());
        double dollars = pounds * rate;
        System.out.printf("%.3f", dollars);
    }
}
