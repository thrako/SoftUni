package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N12TheMatrix_recursive {
    private static Character[][] matrix;
    private static int rows;
    private static int columns;
    private static int startRow;
    private static int startCol;
    private static char soughtChar;
    private static char replacementChar;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        readInput(scanner);
        replace(startRow, startCol);
        printMatrix();
    }

    private static void readInput(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        rows = dimensions[0];
        columns = dimensions[1];

        matrix = new Character[rows][];
        for (int r = 0; r < rows; r++) {
            Character[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(c -> c.charAt(0))
                    .toArray(Character[]::new);
            matrix[r] = row;
        }

        replacementChar = scanner.nextLine().charAt(0);

        int[] startData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        startRow = startData[0];
        startCol = startData[1];
        soughtChar = matrix[startRow][startCol];
    }

    private static void replace(int row, int col) {
        matrix[row][col] = replacementChar;

        replaceIfSought(row + 1, col);
        replaceIfSought(row - 1, col);
        replaceIfSought(row, col + 1);
        replaceIfSought(row, col - 1);
    }

    private static void replaceIfSought(int r, int c) {
        if (isInBounds(r, c) && matrix[r][c] == soughtChar) replace(r, c);
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && c >= 0 && r < rows && c < columns;
    }

    private static void printMatrix() {
        for (Character[] row : matrix) {
            System.out.println(Arrays.stream(row)
                    .map(String::valueOf)
                    .collect(Collectors.joining("")));
        }
    }
}
