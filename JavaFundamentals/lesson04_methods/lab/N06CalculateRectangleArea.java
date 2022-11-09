package lesson04_methods.lab;

import java.util.Scanner;

public class N06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int area = getRectangleArea(width, height);
        System.out.println(area);
    }

    private static int getRectangleArea(int width, int height) {
        return width * height;
    }
}
