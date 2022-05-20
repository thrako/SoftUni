package datatypesandvariables.lab;

import java.util.Scanner;

public class N01_Convert_Meters_to_Km {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputM = Double.parseDouble(scanner.nextLine());
        System.out.printf("%.2f", inputM / 1000);
    }
}
