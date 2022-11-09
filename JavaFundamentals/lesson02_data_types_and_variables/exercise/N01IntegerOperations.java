package lesson02_data_types_and_variables.exercise;

import java.util.Scanner;

public class N01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        int fourth = Integer.parseInt(scanner.nextLine());
        int sum = (first + second) / third * fourth;
        System.out.println(sum);
    }
}
