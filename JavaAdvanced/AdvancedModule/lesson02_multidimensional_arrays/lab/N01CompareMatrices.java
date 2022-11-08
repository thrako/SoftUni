package lesson02_multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        System.out.println((areEqual(firstMatrix, secondMatrix))
                ? "equal"
                : "not equal"
        );
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) return false;
        for (int i = 0, rowLength = firstMatrix.length; i < rowLength; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length) return false;
            for (int j = 0, colLength = firstMatrix[i].length; j < colLength; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) return false;
            }
        }
        return true;
    }
}
