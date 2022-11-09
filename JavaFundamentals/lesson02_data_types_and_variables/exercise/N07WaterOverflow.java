package lesson02_data_types_and_variables.exercise;

import java.util.Scanner;

public class N07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = 255;
        int filledQty = 0;
        int lines = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        while (counter < lines) {
            int currentQty = Integer.parseInt(scanner.nextLine());
            if (filledQty + currentQty > capacity) {
                System.out.println("Insufficient capacity!");
            } else {
                filledQty += currentQty;
            }
            counter++;
        }
        System.out.println(filledQty);
    }
}
