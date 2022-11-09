package lesson04_methods.lab;

import java.util.Scanner;

public class N05Orders {
    private static final double coffeePrc = 1.50;
    private static final double waterPrc = 1.00;
    private static final double cokePrc = 1.40;
    private static final double snacksPrc = 2.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        int qty = Integer.parseInt(scanner.nextLine());
        buyItem(item, qty);
    }

    private static void buyItem(String item, int qty) {
        double sum = 0;

        switch (item){
            case "coffee":
                sum += qty * coffeePrc;
                break;
            case "water":
                sum += qty * waterPrc;
                break;
            case "coke":
                sum += qty * cokePrc;
                break;
            case "snacks":
                sum += qty * snacksPrc;
                break;
            default:
                System.out.println("Invalid item");
        }
        System.out.printf("%.2f", sum);
    }
}