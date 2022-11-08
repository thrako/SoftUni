package lesson01_working_with_abstraction.lab.n04_hotel_reservation;

public class PriceCalculator {

    public static double calculate(double pricePerDay, int daysCount, Seasons season, Discounts discountType) {
        return pricePerDay * daysCount * season.getMultiplier() * (1 - discountType.getPercentage());
    }

}
