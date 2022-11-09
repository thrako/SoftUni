package lesson01_basic_syntax.lab;

import java.util.Scanner;

public class N07TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        int age = scanner.nextInt();
        int ticketPrice = 0;

        switch (day) {
            case "Weekday":
                if (age <= 18) {
                    ticketPrice = 12;
                } else if (age <= 64) {
                    ticketPrice = 18;
                } else if (age <= 122) {
                    ticketPrice = 12;
                }
                break;
            case "Weekend":
                if (age <= 18) {
                    ticketPrice = 15;
                } else if (age <= 64) {
                    ticketPrice = 20;
                } else if (age <= 122) {
                    ticketPrice = 15;
                }
                break;
            case "Holiday":
                if (age <= 18) {
                    ticketPrice = 5;
                } else if (age <= 64) {
                    ticketPrice = 12;
                } else if (age <= 122) {
                    ticketPrice = 10;
                }
                break;
        }

        if (age < 0 || age > 122) {
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", ticketPrice);
        }
    }
}
