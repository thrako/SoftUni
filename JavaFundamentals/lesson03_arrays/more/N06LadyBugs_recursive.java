package lesson03_arrays.more;

import java.util.Arrays;
import java.util.Scanner;

public class N06LadyBugs_recursive {
    private static int fieldSize;
    private static int[] field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initField(scanner);
        fillInitPositions(scanner);
        processInput(scanner);
        printField();
    }

    private static void initField(Scanner scanner) {
        fieldSize = Integer.parseInt(scanner.nextLine());
        field = new int[fieldSize];
    }

    private static void fillInitPositions(Scanner scanner) {
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(N06LadyBugs_recursive::isInRange)
                .forEach(e -> field[e] = 1);
    }

    private static void processInput(Scanner scanner) {

        String[] commands = scanner.nextLine().split(" ");

        if (commands[0].equals("end")) {
            return;

        } else {
            int origin = Integer.parseInt(commands[0]);
            int distance = getDistance(commands[1], Integer.parseInt(commands[2]));

            if (isInRange(origin) && !isEmpty(origin)) {
                emptyField(origin);
                move(origin, distance);
            }

            processInput(scanner);
        }
    }

    private static void printField() {
        if (fieldSize > 0) {
            StringBuilder printSB = new StringBuilder();
            for (int i = 0; i < fieldSize - 1; i++) {
                printSB.append(field[i]).append(" ");
            }
            printSB.append(field[fieldSize - 1]);
            System.out.println(printSB);
        } else {
            System.out.println();
        }
    }

    private static boolean isInRange(int num) {
        return num >= 0 && num <= fieldSize - 1;
    }

    private static boolean isEmpty(int index) {
        return field[index] == 0;
    }

    private static void emptyField(int origin) {
        field[origin] = 0;
    }

    private static int getDistance(String direction, int length) {

        if (direction.equals("right")) {
            return length;
        } else if (direction.equals("left")) {
            return -(length);
        }
        return 0;
    }

    private static void move(int origin, int distance) {

        int destination = origin + distance;

        if (!isInRange(destination)) {
            return;
        } else if (isEmpty(destination)) {
            field[destination] = 1;
            return;
        }
        move(origin + distance, distance);
    }
}
