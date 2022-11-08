package lesson02_multidimensional_arrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N07Crossfire {
    private static final String END = "Nuke it from orbit";
    private static List<List<Integer>> matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = getIntArray(scanner.nextLine());
        int rows = dimensions[0];
        int columns = dimensions[1];

        int counter = 0;
        matrix = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            ArrayList<Integer> nextRow = new ArrayList<>();
            for (int c = 0; c < columns; c++) {
                nextRow.add(++counter);
            }
            matrix.add(nextRow);
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

        for (List<Integer> row : matrix) {
            System.out.println(row.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }

    private static void remove(int targetRowIdx, int targetCellIdx, int radius) {

        for (int rowIdx = targetRowIdx + radius; rowIdx >= targetRowIdx - radius; rowIdx--) {
            if (!isValidRow(rowIdx)) continue;

            if (rowIdx == targetRowIdx) {
                //horizontal right-left
                for (int cell = targetCellIdx + radius; cell >= targetCellIdx - radius; cell--) {
                    if (isValidCell(rowIdx, cell)) matrix.get(rowIdx).remove(cell);
                }

                //vertical bottom-up
            } else if (isValidCell(rowIdx, targetCellIdx)) matrix.get(rowIdx).remove(targetCellIdx);

            //remove row if empty
            if (matrix.get(rowIdx).isEmpty()) matrix.remove(rowIdx);
        }
    }

    private static int[] getIntArray(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isValidRow(int row) {
        return row >= 0 && row < matrix.size();
    }

    private static boolean isValidCell(int row, int cellIdx) {
        return row >= 0
               && cellIdx >= 0
               && row < matrix.size()
               && cellIdx < matrix.get(row).size();
    }
}