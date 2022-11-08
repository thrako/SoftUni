package lesson01_working_with_abstraction.lab.n04_hotel_reservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] lineParts = scanner.nextLine().split("\\s+");

        final double pricePerDay = Double.parseDouble(lineParts[0]);
        final int daysCount = Integer.parseInt(lineParts[1]);
        final Seasons season = Seasons.valueOf(lineParts[2]);
        final Discounts discountType = Discounts.valueOf(lineParts[3]);

        final double totalPrice = PriceCalculator.calculate(pricePerDay, daysCount, season, discountType);

        System.out.printf("%.2f", totalPrice);
    }

}
