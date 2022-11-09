package lesson02_data_types_and_variables.exercise;

import java.util.Scanner;

public class N03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int courses = (int) Math.ceil((double) numPeople / capacity);
        System.out.println(courses);
    }
}
