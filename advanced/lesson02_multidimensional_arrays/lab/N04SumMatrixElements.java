package lesson02_multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = readMatrix(scanner, rows, columns);

        int sum = 0;
        for (int[] row : matrix) {
            sum += Arrays.stream(row).sum();
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);


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
