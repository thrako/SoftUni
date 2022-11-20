package lesson04_interfaces.lab.n02_car_shop_extended;

public interface Rentable {
    String RENTABLE_PRINT_FORMAT = "Minimum rental period of %d days. Price per day %f";

    Integer getMinRentDay();

    Double getPricePerDay();

}
