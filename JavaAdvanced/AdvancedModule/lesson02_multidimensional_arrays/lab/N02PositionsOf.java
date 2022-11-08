package lesson02_multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int soughtNumber = Integer.parseInt(scanner.nextLine());
        searchNumber(matrix, soughtNumber);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions;
        int rows, columns;
        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        rows = dimensions[0];
        columns = dimensions[1];
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    private static void searchNumber(int[][] matrix, int soughtNumber) {
        boolean isFound = false;
        for (int r = 0, rows = matrix.length; r < rows; r++) {
            for (int c = 0, cols = matrix[0].length; c < cols; c++) {
                if (matrix[r][c] == soughtNumber) {
                    System.out.println(r + " " + c);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
