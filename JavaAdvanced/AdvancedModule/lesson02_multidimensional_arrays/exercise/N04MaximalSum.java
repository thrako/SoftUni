package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = parseIntArray(scanner);
        int rows = dimensions[0];
        int columns = dimensions[1];

        if (rows < 3 || columns < 3) return;

        int[][] matrix = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            matrix[r] = parseIntArray(scanner);
        }
        int maxSum = 0;
        int[][] maxSubMatrix = new int[3][3];
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < columns - 2; c++) {
                int tempSum = 0;
                int[][] tempSubMatrix = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        tempSubMatrix[i][j] = matrix[r + i][c + j];
                        tempSum += tempSubMatrix[i][j];
                    }
                }
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                    maxSubMatrix = tempSubMatrix;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        print(maxSubMatrix);
    }

    private static int[] parseIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.stream(row)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }
}
