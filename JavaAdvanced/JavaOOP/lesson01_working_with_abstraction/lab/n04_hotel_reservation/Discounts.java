package lesson01_working_with_abstraction.lab.n04_hotel_reservation;

public enum Discounts {
    VIP(0.20),
    SecondVisit(0.10),
    None(0.00);

    private final double percentage;

    Discounts(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
