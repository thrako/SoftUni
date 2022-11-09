package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N01ConvertMetersToKm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputM = Double.parseDouble(scanner.nextLine());
        System.out.printf("%.2f", inputM / 1000);
    }
}
