package lesson02_multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner);

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            try {
                swap(matrix, input);
                print(matrix);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static String[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        String[][] matrix = new String[rows][columns];
        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static void swap(String[][] matrix, String input) {
        Pattern pattern = Pattern.compile("swap[\\s]+([\\d]+)[\\s]+([\\d]+)[\\s]+([\\d]+)[\\s]+([\\d]+)");
        Matcher matcher = pattern.matcher(input);
        int firstRow = -1, firstColumn = -1, secondRow = -1, secondColumn = -1;
        if (matcher.matches()) {
            firstRow = Integer.parseInt(matcher.group(1));
            firstColumn = Integer.parseInt(matcher.group(2));
            secondRow = Integer.parseInt(matcher.group(3));
            secondColumn = Integer.parseInt(matcher.group(4));
        }
        String temp = matrix[firstRow][firstColumn];
        matrix[firstRow][firstColumn] = matrix[secondRow][secondColumn];
        matrix[secondRow][secondColumn] = temp;
    }

    private static void print(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(String.join(" ", row));
        }
    }
}
