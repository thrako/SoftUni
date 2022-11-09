package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPersons = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double qtyDiscount = 0;
        double priceDiscount = 0;

        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }

                if (numberPersons >= 30) {
                    priceDiscount = 0.15;
                }
                break;

            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16.0;
                        break;
                }
                if (numberPersons >= 100) {
                    qtyDiscount = 10;
                }
                break;

            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                if (10 <= numberPersons && numberPersons <= 20) {
                    priceDiscount = 0.05;
                }
                break;
        }
        double totalPrice = (numberPersons - qtyDiscount) * price * (1 - priceDiscount);
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
