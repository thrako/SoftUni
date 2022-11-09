package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOrders = Integer.parseInt(scanner.nextLine());
        double totalAmount = 0;
        for (int i = 0; i < numOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int daysInMonth = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double orderAmount = ((daysInMonth * capsulesCount) * pricePerCapsule);
            System.out.printf("The price for the coffee is: $%.2f%n", orderAmount);
            totalAmount += orderAmount;
        }
        System.out.printf("Total: $%.2f", totalAmount);
    }
}
