package lesson02_multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = readMatrix(scanner, rows, columns);
        int[][] subMatrix = new int[2][2];
        int maxSum = 0;
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < columns - 1; c++) {
                int ul = matrix[r][c];
                int ur = matrix[r][c + 1];
                int dl = matrix[r + 1][c];
                int dr = matrix[r + 1][c + 1];
                int sum = ul + ur + dl + dr;
                if (sum > maxSum) {
                    maxSum = sum;
                    subMatrix[0][0] = ul;
                    subMatrix[0][1] = ur;
                    subMatrix[1][0] = dl;
                    subMatrix[1][1] = dr;
                }
            }
        }
        System.out.println(subMatrix[0][0] + " " + subMatrix[0][1]);
        System.out.println(subMatrix[1][0] + " " + subMatrix[1][1]);
        System.out.println(maxSum);


    }
    private static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
