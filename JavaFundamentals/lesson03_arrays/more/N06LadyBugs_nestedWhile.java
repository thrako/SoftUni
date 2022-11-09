package lesson03_arrays.more;

import java.util.Arrays;
import java.util.Scanner;

public class N06LadyBugs_nestedWhile {
    private static int fieldSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fieldSize = Integer.parseInt(scanner.nextLine());
        int[] field = new int[fieldSize];

        int[] initPositions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int pos : initPositions) {
            if (isInRange(pos)) {
                field[pos] = 1;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            int fromIndex = Integer.parseInt(commands[0]);
            if (isInRange(fromIndex) && field[fromIndex] == 1) { //if the index is within the field AND there is a lady bug on it
                field[fromIndex] = 0; //the lady bug flies away from its initial index

                String direction = commands[1];
                int length = Integer.parseInt(commands[2]);
                int flyLength = 0;
                if (direction.equals("right")) {
                    flyLength += length;
                } else if (direction.equals("left")) {
                    flyLength -= length;
                }

                int toIndex = fromIndex + flyLength;

                while (isInRange(toIndex)) {
                    if (field[toIndex] == 0) { //if the field index is empty, the lady bug lands here
                        field[toIndex] = 1;
                        break;
                    }
                    toIndex += flyLength; //if the field index is not empty the lady bug tries again (same direction and length)
                }
            }

            input = scanner.nextLine();
        }

        StringBuilder printSB = new StringBuilder();
        for (int i = 0; i < fieldSize; i++) {
            printSB.append(field[i]).append(" ");
        }

        System.out.println(printSB);
    }

    private static boolean isInRange(int num) {
        return num >= 0 && num <= fieldSize - 1;
    }
}