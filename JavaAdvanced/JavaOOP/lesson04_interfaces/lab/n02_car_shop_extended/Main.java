package lesson04_interfaces.lab.n02_car_shop_extended;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        printCarInfo((Car) seat);
        printCarInfo((Car) audi);
    }

    private static void printCarInfo(Car car) {
        System.out.printf(
                "%s is %s color and have %s horse power%n",
                car.getModel(), car.getColor(), car.getHorsePower());
        System.out.println(car);
    }

}
