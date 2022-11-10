package lesson02_encapsulation.exercise.n01_class_box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        try {
            Box box = new Box(length, width, height);
            String output = String.format("Surface Area - %.2f%n", box.calculateSurfaceArea()) +
                            String.format("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea()) +
                            String.format("Volume - %.2f%n", box.calculateVolume());
            System.out.println(output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
