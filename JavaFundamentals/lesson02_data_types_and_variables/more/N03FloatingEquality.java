package lesson02_data_types_and_variables.more;

import java.util.Scanner;

public class N03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        String areEqual = (Math.abs(a - b) <= 0.000001) ? "True" : "False";
        System.out.println(areEqual);

    }
}
