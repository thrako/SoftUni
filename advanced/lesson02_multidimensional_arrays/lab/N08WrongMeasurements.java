package lesson02_multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsCount = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, rowsCount);
        int[][] outputMatrix = new int[rowsCount][matrix[0].length];
        for (int r = 0; r < rowsCount; r++) {
            System.arraycopy(matrix[r], 0, outputMatrix[r], 0, matrix[r].length);
        }

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int wrongNumber = matrix[coordinates[0]][coordinates[1]];

        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0, rowLength = matrix[r].length; c < rowLength; c++) {
                if (matrix[r][c] != wrongNumber) continue;
                int up = (isValid(wrongNumber, matrix, r, c - 1))
                        ? matrix[r][c - 1]
                        : 0;
                int down = (isValid(wrongNumber, matrix, r, c + 1))
                        ? matrix[r][c + 1]
                        : 0;
                int left = (isValid(wrongNumber, matrix, r - 1, c))
                        ? matrix[r - 1][c]
                        : 0;
                int right = (isValid(wrongNumber, matrix, r + 1, c))
                        ? matrix[r + 1][c]
                        : 0;
                int sum = up + down + left + right;
                outputMatrix[r][c] = sum;
            }
        }

        for (int[] row : outputMatrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

    }

    private static boolean isValid(int wrongNumber, int[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length) return false;
        if (col < 0 || col >= matrix[row].length) return false;
        return matrix[row][col] != wrongNumber;
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
