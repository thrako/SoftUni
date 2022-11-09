package lesson04_methods.more;

import java.util.Arrays;
import java.util.Scanner;

public class N03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstLine = getLine(scanner);
        int[][] secondLine = getLine(scanner);
        if (getLengthOf(firstLine) >= getLengthOf(secondLine)) print(firstLine);
        else print(secondLine);
    }

    private static void print(int[][] line) {
        System.out.printf("(%d, %d)(%d, %d)", line[0][0], line[0][1], line[1][0], line[1][1]);
    }

    private static double getLengthOf(int[][] line) {
        double x1 = line[0][0], y1 = line[0][1], x2 = line[1][0], y2 = line[1][1];
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    private static int[][] getLine(Scanner scanner) {
        int[][] line = {
                {
                        Integer.parseInt(scanner.nextLine()),
                        Integer.parseInt(scanner.nextLine())
                },
                {
                        Integer.parseInt(scanner.nextLine()),
                        Integer.parseInt(scanner.nextLine())
                }
        };
        if (getDistanceToCenter(line[0]) <= getDistanceToCenter(line[1])) return line;
        return swapElements(line);
    }

    private static int[][] swapElements(int[][] line) {
        int[] temp = Arrays.copyOf(line[0], line[0].length);
        line[0] = Arrays.copyOf(line[1], line[1].length);
        line[1] = Arrays.copyOf(temp, temp.length);
        return line;
    }

    private static double getDistanceToCenter(int[] point) {
        return Math.sqrt(Math.pow((point[0]), 2) + Math.pow((point[1]), 2));
    }
}
