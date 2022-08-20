package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split(",\\s+");
        int side = Integer.parseInt(inputData[0]);
        String patternType = inputData[1];
        if ("A".equals(patternType)) {
            drawMatrixTypeA(side);
        } else if ("B".equals(patternType)) {
            drawMatrixTypeB(side);
        }
    }

    private static void drawMatrixTypeB(int side) {
        int[][] matrix = new int[side][side];
        int counter = 0;
        for (int col = 0; col < side; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < side; row++) {
                    matrix[row][col] = ++counter;
                }
            } else {
                for (int row = side - 1; row >= 0; row--) {
                    matrix[row][col] = ++counter;
                }
            }
        }
        print(matrix);
    }

    private static void drawMatrixTypeA(int side) {
        int[][] matrix = new int[side][side];
        int counter = 0;
        for (int col = 0; col < side; col++) {
            for (int row = 0; row < side; row++) {
                matrix[row][col] = ++counter;
            }
        }
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.stream(row)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }
}
