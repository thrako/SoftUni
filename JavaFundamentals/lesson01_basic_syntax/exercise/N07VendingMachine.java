package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N07VendingMachine {
    public static void main(String[] args) {
        double nutsPrice = 2.0;
        double waterPrice = 0.7;
        double crispsPrice = 1.5;
        double sodaPrice = 0.8;
        double cokePrice = 1.0;

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double deposit = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 ||
                    coin == 0.2 ||
                    coin == 0.5 ||
                    coin == 1 ||
                    coin == 2) {
                deposit += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            boolean isValidPurchase = false;
            switch (input) {
                case "Nuts":
                    if (deposit >= nutsPrice) {
                        deposit -= nutsPrice;
                        isValidPurchase = true;
                    }
                    break;
                case "Water":
                    if (deposit >= waterPrice) {
                        deposit -= waterPrice;
                        isValidPurchase = true;
                    }
                    break;
                case "Crisps":
                    if (deposit >= crispsPrice) {
                        deposit -= crispsPrice;
                        isValidPurchase = true;
                    }
                    break;
                case "Soda":
                    if (deposit >= sodaPrice) {
                        deposit -= sodaPrice;
                        isValidPurchase = true;
                    }
                    break;
                case "Coke":
                    if (deposit >= cokePrice) {
                        deposit -= cokePrice;
                        isValidPurchase = true;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    input = scanner.nextLine();
                    continue;
            }

            if (isValidPurchase) {
                System.out.printf("Purchased %s%n", input);
            } else {
                System.out.println("Sorry, not enough money");
            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", deposit);
    }
}
