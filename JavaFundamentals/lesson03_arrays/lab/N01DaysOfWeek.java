package lesson03_arrays.lab;

import java.util.Scanner;

public class N01DaysOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int number = Integer.parseInt(scanner.nextLine());
        if (0 < number && number <= days.length) {
            System.out.println(days[number - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
