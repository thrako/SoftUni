package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[side][side];
        for (int r = 0; r < side; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int leftDiagonal = sumDiagonal(matrix, side, "left");
        int rightDiagonal = sumDiagonal(matrix, side, "right");
        int absSumOfDiagonals = Math.abs(leftDiagonal - rightDiagonal);
        System.out.println(absSumOfDiagonals);

    }

    private static int sumDiagonal(int[][] matrix, int side, String direction) {
        int sum = 0;
        if ("left".equals(direction)) {
            for (int i = 0; i < side; i++) {
                sum += matrix[i][i];
            }
        }
        if ("right".equals(direction)) {
            for (int i = 0; i < side; i++) {
                sum += matrix[i][side - 1 - i];
            }
        }
        return sum;
    }
}
