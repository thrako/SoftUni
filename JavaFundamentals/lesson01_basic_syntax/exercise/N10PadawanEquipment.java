package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceLightSabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());
        int numLightSabers = (int) Math.ceil(studentsCount * (1 + 0.1));
        int numRobes = studentsCount;
        int numBelts = studentsCount - (studentsCount / 6);
        double totalBill = numLightSabers * priceLightSabers + numRobes * priceRobes + numBelts * priceBelts;
        if (budget >= totalBill) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalBill);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalBill - budget);
        }
    }
}
