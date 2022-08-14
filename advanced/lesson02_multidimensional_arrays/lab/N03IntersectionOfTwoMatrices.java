package lesson02_multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        Character[][] firstMatrix = readMatrix(scanner, rows, columns);
        Character[][] secondMatrix = readMatrix(scanner, rows, columns);
        Character[][] intersection = firstMatrix.clone();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (firstMatrix[r][c] != secondMatrix[r][c]) intersection[r][c] = '*';
            }
        }
        for (Character[] intersectionRow : intersection) {
            for (Character ch : intersectionRow) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }

    }
    private static Character[][] readMatrix(Scanner scanner, int rows, int columns) {
        Character[][] matrix = new Character[rows][columns];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(e -> e.charAt(0))
                    .toArray(Character[]::new);
        }
        return matrix;
    }
}
