package lesson04_interfaces.lab.n02_car_shop_extended;

public class Audi extends CarImpl implements Rentable {

    private final Integer minRentDay;
    private final Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return null;
    }

    @Override
    public Double getPricePerDay() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() +
               System.lineSeparator() + String.format(RENTABLE_PRINT_FORMAT, minRentDay, pricePerDay);
    }
}
