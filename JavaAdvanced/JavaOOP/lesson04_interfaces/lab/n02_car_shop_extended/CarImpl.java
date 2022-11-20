package lesson04_interfaces.lab.n02_car_shop_extended;

public class CarImpl implements Car {
    private static final String MODEL_COUNTRY_TIRES_FORMAT = "This is %s produced in %s and have %d tires";

    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String countryProduced;

    protected CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        return String.format(MODEL_COUNTRY_TIRES_FORMAT, model, countryProduced, TIRES);
    }
}
