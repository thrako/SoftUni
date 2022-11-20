package lesson04_interfaces.lab.n02_car_shop_extended;

public class Seat extends CarImpl implements Car, Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return super.toString() +
               System.lineSeparator() + String.format(SELLABLE_PRINT_FORMAT, getModel(), price);
    }
}
