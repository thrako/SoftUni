package my_exams.mid20220625;

import java.util.Scanner;

public class N02TaxCalculator {
    private static double totalTax = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vehicles = scanner.nextLine().split(">>");
        double dueTax;

        for (String vehicle : vehicles) {
            String[] vehicleData = vehicle.split("\\s+");
            String carType = vehicleData[0];
            int years = Integer.parseInt(vehicleData[1]);
            int mileage = Integer.parseInt(vehicleData[2]);

            switch (carType) {
                case "family":
                    FamilyCar familyCar = new FamilyCar(years, mileage);
                    dueTax = familyCar.calculateTax();
                    totalTax += dueTax;
                    printDueTax(carType, dueTax);
                    break;
                case "heavyDuty":
                    HeavyDutyCar heavyDutyCar = new HeavyDutyCar(years, mileage);
                    dueTax = heavyDutyCar.calculateTax();
                    totalTax += dueTax;
                    printDueTax(carType, dueTax);
                    break;
                case "sports":
                    SportsCar sportsCar = new SportsCar(years, mileage);
                    dueTax = sportsCar.calculateTax();
                    totalTax += dueTax;
                    printDueTax(carType, dueTax);
                    break;
                default:
                    System.out.println("Invalid car type.");
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTax);
    }

    private static void printDueTax(String carType, double dueTax) {
        System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, dueTax);
    }

    static class FamilyCar {
        private static final double initTax = 50;
        private static final double taxReliefPerYear = 5;
        private static final int perMileageRate = 3000;
        private static final double taxPerMileageFee = 12;
        int years;
        int mileage;

        public FamilyCar(int years, int mileage) {
            this.years = years;
            this.mileage = mileage;
        }

        public double calculateTax() {
            //noinspection IntegerDivisionInFloatingPointContext
            return initTax - this.years * taxReliefPerYear + this.mileage / perMileageRate * taxPerMileageFee;
        }
    }

    static class HeavyDutyCar {
        private static final double initTax = 80;
        private static final double taxReliefPerYear = 8;
        private static final int perMileageRate = 9000;
        private static final double taxPerMileageFee = 14;
        int years;
        int mileage;

        public HeavyDutyCar(int years, int mileage) {
            this.years = years;
            this.mileage = mileage;
        }

        public double calculateTax() {
            //noinspection IntegerDivisionInFloatingPointContext
            return initTax - this.years * taxReliefPerYear + this.mileage / perMileageRate * taxPerMileageFee;
        }
    }

    static class SportsCar {
        private static final double initTax = 100;
        private static final double taxReliefPerYear = 9;
        private static final int perMileageRate = 2000;
        private static final double taxPerMileageFee = 18;
        int years;
        int mileage;

        public SportsCar(int years, int mileage) {
            this.years = years;
            this.mileage = mileage;
        }

        public double calculateTax() {
            //noinspection IntegerDivisionInFloatingPointContext
            return initTax - this.years * taxReliefPerYear + this.mileage / perMileageRate * taxPerMileageFee;
        }
    }
}
