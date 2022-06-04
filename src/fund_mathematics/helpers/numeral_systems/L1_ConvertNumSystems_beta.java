package helpers.numeral_systems;

import java.math.BigInteger;
import java.util.Scanner;

public class L1_ConvertNumSystems_beta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the BASE of the number to be converted:");
        System.out.println("2 -> binary");
        System.out.println("8 -> octal");
        System.out.println("10 -> decimal");
        System.out.println("16 -> hexadecimal");
        int baseInt = Integer.parseInt(scanner.nextLine());

        System.out.printf("Please input the NUMBER in base (%d)%n", baseInt);
        String[] numberParts = scanner.nextLine().split("\\.");

        BigInteger number = new BigInteger(numberParts[0], baseInt);

        System.out.printf("Binary: %s%n", number.toString(2));
        System.out.printf("Octal: %s%n", number.toString(8));
        if (numberParts.length == 2) {
            printFloating10(numberParts, baseInt);
        } else {
            System.out.printf("Decimal: %s%n", number.toString(10));
        }
        System.out.printf("Hexadecimal: %s%n", number.toString(16).toUpperCase());
    }

    private static void printFloating10(String[] numParts, int base) {
        BigInteger wholePart = new BigInteger(numParts[0], base);
        BigInteger decimalPart = new BigInteger(numParts[1], base);
        BigInteger divisor = new BigInteger(String.valueOf((int) Math.pow(base, numParts[1].length())));


        System.out.printf("%s + %s/%s = ", wholePart.toString(10), decimalPart.toString(10), divisor.toString(10));
        double flNum = Double.parseDouble(wholePart.toString(10)) + Double.parseDouble(decimalPart.toString(10)) / Double.parseDouble(divisor.toString(10));
        String flNumStr = String.valueOf(flNum).strip();
        System.out.printf("%s%n", flNumStr);
    }
}
