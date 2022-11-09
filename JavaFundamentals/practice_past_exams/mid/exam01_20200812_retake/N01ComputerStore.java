package practice_past_exams.mid.exam01_20200812_retake;

import java.util.Scanner;

public class N01ComputerStore {
    private static final double taxRate = 0.2;
    private static final double specialDiscount = 0.1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double price, subTotal = 0;
        while(!"special".equals(input) && !"regular".equals(input)) {
            price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                subTotal += price;
            }
            input = scanner.nextLine();
        }
        if (subTotal == 0) {
            System.out.println("Invalid order!");
        } else {
            double tax = subTotal * taxRate;
            double finalPrice = subTotal + tax;
            if ("special".equals(input)) {
                finalPrice *= (1 - specialDiscount);
            }
            System.out.printf(
                    "Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n",
                    subTotal, tax, finalPrice
            );
        }
    }
}
