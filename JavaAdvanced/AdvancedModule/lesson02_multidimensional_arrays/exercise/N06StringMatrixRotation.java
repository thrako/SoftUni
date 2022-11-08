package lesson02_multidimensional_arrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var degrees = Integer.parseInt(scanner.nextLine().split("[)|(]")[1]) % 360;
        List<String> inputs = getList(scanner);
        int rows = inputs.size();
        int columns = getMaxLength(inputs);
        char[][] matrix = getMatrix(inputs, rows, columns);

        switch (degrees) {
            case 0:
                print(matrix);
                break;
            case 90:
                printRotated90(matrix, rows, columns);
                break;
            case 180:
                printRotated180(matrix, rows, columns);
                break;
            case 270:
                printRotated270(matrix, rows, columns);
                break;
            default:
        }
    }

    private static int getMaxLength(List<String> inputs) {
        int columns = 0;
        for (String str : inputs) {
            if (str.length() > columns) columns = str.length();
        }
        return columns;
    }

    private static List<String> getList(Scanner scanner) {
        List<String> inputs = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            inputs.add(input);
            input = scanner.nextLine();
        }
        return inputs;
    }

    private static char[][] getMatrix(List<String> inputs, int rows, int columns) {
        char[][] matrix = new char[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                String str = inputs.get(r);
                if (c < str.length()) {
                    matrix[r][c] = str.charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }
        return matrix;
    }

    private static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(Stream.of(chars)
                    .map(String::new)
                    .collect(Collectors.joining(" ")));
        }
    }

    private static void printRotated90(char[][] matrix, int rows, int columns) {
        char[][] rotated = new char[columns][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                rotated[c][rows - 1 - r] = matrix[r][c];
            }
        }
        print(rotated);
    }

    private static void printRotated180(char[][] matrix, int rows, int columns) {
        char[][] rotated = new char[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                rotated[rows - 1 - r][columns - 1 - c] = matrix[r][c];
            }
        }
        print(rotated);
    }

    private static void printRotated270(char[][] matrix, int rows, int columns) {
        char[][] rotated = new char[columns][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                rotated[columns - 1 - c][r] = matrix[r][c];
            }
        }
        print(rotated);
    }
}
