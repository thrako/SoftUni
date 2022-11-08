package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        String[][] matrix = new String[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                 matrix[r][c] = getSymbol(r) + getSymbol(r+c) + getSymbol(r);
            }
        }
        print(matrix);
    }

    private static String getSymbol(int i) {
        return String.valueOf ((char) (97 + i));
    }

    private static void print(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(String.join(" ", row));
        }
    }

}
