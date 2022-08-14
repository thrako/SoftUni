package my_exams.mid20220625;

import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class N02TaxCalculator_OOP {
    private static double totalTax = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vehicles = scanner.nextLine().split(">>");
        double dueTax;
        CarFactory carFactory = new CarFactory();

        for (String vehicle : vehicles) {
            String[] vehicleData = vehicle.split("\\s+");
            String carType = vehicleData[0];
            int years = Integer.parseInt(vehicleData[1]);
            int mileage = Integer.parseInt(vehicleData[2]);
            Taxable car = carFactory.getCar(carType, years, mileage);
            if (car != null) {
                dueTax = car.calculateTax();
                totalTax += dueTax;
                printDueTax(carType, dueTax);
            } else {
                System.out.println("Invalid car type.");
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTax);
    }


    private static void printDueTax(String carType, double dueTax) {
        System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, dueTax);
    }

    interface Taxable {
        double calculateTax();
    }

    abstract static class Car implements Taxable {
        protected double initTax;
        protected double taxReliefPerYear;
        protected double taxPerMileageFee;
        protected int perMileageRate;
        protected int years;
        protected int mileage;

        public Car withYears(int years) {
            this.years = years;
            return this;
        }

        public Car withMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public double calculateTax() {
            return initTax - years * taxReliefPerYear + (double) (mileage / perMileageRate) * taxPerMileageFee;
        }
    }

    static final class FamilyCar extends Car {

        public FamilyCar() {
            this.initTax = 50;
            this.taxReliefPerYear = 5;
            this.taxPerMileageFee = 12;
            this.perMileageRate = 3000;
        }

    }
    static class HeavyDutyCar extends Car {

        public HeavyDutyCar() {
            this.initTax = 80;
            this.taxReliefPerYear = 8;
            this.taxPerMileageFee = 14;
            this.perMileageRate = 9000;
        }

    }
    static class SportsCar extends Car {

        public SportsCar() {
            this.initTax = 100;
            this.taxReliefPerYear = 9;
            this.taxPerMileageFee = 18;
            this.perMileageRate = 2000;
        }

    }
    static class CarFactory {
        Map<String, Car> supportedTypes = Map.ofEntries(
                entry("family", new FamilyCar()),
                entry("heavyDuty", new HeavyDutyCar()),
                entry("sports", new SportsCar())
        );

        public Car getCar(String carType, int years, int mileage) {
            if (supportedTypes.containsKey(carType)) {

                return supportedTypes.get(carType)
                        .withYears(years)
                        .withMileage(mileage);
            }
            return null;
        }
    }
}
