package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = getIntArray(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        boolean[][] parking = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                parking[r][c] = true;
            }
        }


        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            int[] data = getIntArray(input);
            int entryRow = data[0];
            int targetRow = data[1];
            int targetCol = data[2];
            int parkedIdx;
            if (isFree(parking[targetRow], targetCol))
                parkedIdx = targetCol;
            else
                parkedIdx = findFreePlace(parking, targetRow, targetCol);

            if (parkedIdx == -1)
                System.out.printf("Row %d full%n", targetRow);
            else {
                parking[targetRow][parkedIdx] = false;
                int distance = Math.abs(entryRow - targetRow) + parkedIdx + 1;
                System.out.println(distance);
            }
            input = scanner.nextLine();
        }
    }

    private static int findFreePlace(boolean[][] parking, int targetRow, int targetCol) {
        int length = parking[targetRow].length;
        for (int i = 1; i < length; i++) {
            if (isValid(targetCol - i, length) && isFree(parking[targetRow], targetCol - i)) {
                return targetCol - i;
            }
            if (isValid(targetCol + i, length) && isFree(parking[targetRow], targetCol + i)) {
                return targetCol + i;
            }
        }
        return -1;
    }

    private static boolean isFree(boolean[] parkingRow, int targetCol) {
        return parkingRow[targetCol];
    }

    private static boolean isValid(int idx, int length) {
        return idx >= 1 && idx < length;
    }

    private static int[] getIntArray(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
