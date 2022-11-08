package lesson01_working_with_abstraction.lab.n02_point_in_rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int[] rectangleData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        final int bottomLeftX = rectangleData[0];
        final int bottomLeftY = rectangleData[1];
        final int topRightX = rectangleData[2];
        final int topRightY = rectangleData[3];

        final Point bottomLeftPoint = new Point(bottomLeftX, bottomLeftY);
        final Point topRightPoint = new Point(topRightX, topRightY);

        Rechtangle rechtangle = new Rechtangle(bottomLeftPoint, topRightPoint);

        int pointsCounter = Integer.parseInt(scanner.nextLine());

        while (pointsCounter-- > 0) {
            final int[] pointData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            final int pointX = pointData[0];
            final int pointY = pointData[1];
            Point point = new Point(pointX, pointY);
            System.out.println(rechtangle.contains(point));
        }
    }
}
