package lesson02_multidimensional_arrays.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N12TheMatrix {
    private static final Deque<Integer> FOR_REPLACEMENT_STACK = new ArrayDeque<>();
    private static Character[][] matrix;
    private static int rows;
    private static int columns;
    private static char findChar;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        char replaceChar = scanner.nextLine().charAt(0);

        int[] startData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startRow = startData[0];
        int startCol = startData[1];

        findChar = matrix[startRow][startCol];

        FOR_REPLACEMENT_STACK.push(convert(startRow, startCol));
        while (!FOR_REPLACEMENT_STACK.isEmpty()) {
            int cellIdx = FOR_REPLACEMENT_STACK.pop();
            var cellRow = getRow(cellIdx);
            var cellCol = getCol(cellIdx);
            matrix[cellRow][cellCol] = replaceChar;

            pushIfValid(cellRow + 1, cellCol);
            pushIfValid(cellRow - 1, cellCol);
            pushIfValid(cellRow, cellCol + 1);
            pushIfValid(cellRow, cellCol - 1);
        }

        for (Character[] row : matrix) {
            System.out.println(Arrays.stream(row)
                    .map(String::valueOf)
                    .collect(Collectors.joining("")));
        }

    }

    private static void pushIfValid(int row, int col) {
        if (isInRange(row, col) && matrix[row][col] == findChar) {
            FOR_REPLACEMENT_STACK.push(convert(row, col));
        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && c >= 0 && r < rows && c < columns;
    }

    private static int convert(int r, int c) {
        return r * columns + c;
    }

    private static int getRow(int idx) {
        return idx / columns;
    }

    private static int getCol(int idx) {
        return idx % columns;
    }
}
