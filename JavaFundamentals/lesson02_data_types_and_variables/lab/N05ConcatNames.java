package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N05ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();
        System.out.printf("%s%s%s", firstName, delimiter, lastName);
    }
}
