package lesson02_multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side = 8;
        var matrix = readMatrix(scanner, side, side);
        for (int r = 0; r < side; r++) {
            for (int c = 0; c < side; c++) {
                if (isRealQueen(matrix, r, c, side)) {
                    System.out.println(r + " " + c);
                    break;
                }
            }
        }
    }

    private static boolean isRealQueen(Character[][] matrix, int r, int c, int side) {
        if (matrix[r][c] != 'q') return false;
        for (int i = 0; i < side; i++) {
            // same column
            if (i != r && matrix[i][c] == 'q') return false;
            // same row
            if (i != c && matrix[r][i] == 'q') return false;

            for (int j = 0; j < side; j++) {
                // same diagonal "/"
                if ((i != r || j != c) && ((i - j) == (r - c)) && (matrix[i][j] == 'q')) return false;
                // same diagonal "\"
                if ((i != r || j != c) && ((i + j) == (r + c)) && (matrix[i][j] == 'q')) return false;
            }
        }
        return true;
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
