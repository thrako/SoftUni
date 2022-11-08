package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N07CrossfireArraysOnly {
    private static final String END = "Nuke it from orbit";
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = getIntArray(scanner.nextLine());
        int rows = dimensions[0];
        int columns = dimensions[1];

        int counter = 0;
        matrix = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                matrix[r][c] = ++counter;
            }
        }

        String input = scanner.nextLine();
        while (!END.equals(input)) {
            int[] targetData = getIntArray(input);
            int targetRow = targetData[0];
            int targetColumn = targetData[1];
            int radius = targetData[2];
            remove(targetRow, targetColumn, radius);
            input = scanner.nextLine();
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.stream(row)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }

    private static void remove(int targetRowIdx, int targetCellIdx, int radius) {

        for (int rowIdx = targetRowIdx + radius; rowIdx >= targetRowIdx - radius; rowIdx--) {
            if (!isValidRow(rowIdx)) continue;

            if (rowIdx == targetRowIdx) {
                //horizontal right-left
                for (int cell = targetCellIdx + radius; cell >= targetCellIdx - radius; cell--) {
                    if (isValidCell(rowIdx, cell)) destroyCell(rowIdx, cell);
                }

                //vertical bottom-up
            } else if (isValidCell(rowIdx, targetCellIdx)) destroyCell(rowIdx, targetCellIdx);

            //remove row if empty
            if (matrix[rowIdx].length == 0) destroyRow(rowIdx);
        }
    }

    private static void destroyRow(int rowIdx) {
        int[][] copyMatrix = new int[matrix.length - 1][];
        int copyMatrixIdx = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == rowIdx) continue;
            copyMatrix[copyMatrixIdx++] = matrix[i];
        }
        matrix = copyMatrix;
    }

    private static void destroyCell(int rowIdx, int cell) {
        int[] copyArr = new int[matrix[rowIdx].length - 1];
        int copyIdx = 0;
        for (int i = 0; i < matrix[rowIdx].length; i++) {
            if (i == cell) continue;
            copyArr[copyIdx++] = matrix[rowIdx][i];
        }
        matrix[rowIdx] = copyArr;
    }

    private static int[] getIntArray(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isValidRow(int row) {
        return row >= 0 && row < matrix.length;
    }

    private static boolean isValidCell(int row, int cellIdx) {
        return row >= 0
               && cellIdx >= 0
               && row < matrix.length
               && cellIdx < matrix[row].length;
    }
}