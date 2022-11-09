package lesson04_methods.more;

import java.util.Scanner;

public class N02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstPoint = {
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine())
        };
        int[] secondPoint = {
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine())
        };
        int[] closestToCenter = getClosest(firstPoint, secondPoint);
        System.out.printf("(%d, %d)", closestToCenter[0], closestToCenter[1]);
    }

    private static int[] getClosest(int[] firstPoint, int[] secondPoint) {
        if (getDistanceToCenter(firstPoint) <= getDistanceToCenter(secondPoint)) return firstPoint;
        return secondPoint;

    }

    private static double getDistanceToCenter(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
