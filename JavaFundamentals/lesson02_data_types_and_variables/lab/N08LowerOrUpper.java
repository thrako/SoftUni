package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(ch)) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
