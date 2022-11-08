package my_exam.T02_rally_racing;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static int side;
    private static String carNumber;
    private static char[][] raceTrack;
    private static int carPosRow = 0;
    private static int carPosCol = 0;
    private static int distanceCovered = 0;
    private static boolean raceFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initRace(scanner);

        String command = scanner.nextLine();
        while (!"End".equals(command) && !raceFinished) {
            moveCar(command);
            command = scanner.nextLine();
        }

        printResults();

    }

    private static void initRace(Scanner scanner) {
        side = Integer.parseInt(scanner.nextLine());
        carNumber = scanner.nextLine();
        raceTrack = new char[side][];
        for (int r = 0; r < side; r++) {
            raceTrack[r] = Arrays.stream(scanner.nextLine().split(" "))
                    .collect(Collectors.joining())
                    .toCharArray();
        }
        raceTrack[0][0] = 'C';
    }

    private static void moveCar(String command) {
        raceTrack[carPosRow][carPosCol] = '.';
        int currRow = carPosRow;
        int currCol = carPosCol;

        switch (command) {
            case "left":
                currCol -= 1;
                break;
            case "right":
                currCol += 1;
                break;
            case "up":
                currRow -= 1;
                break;
            case "down":
                currRow += 1;
        }

        if (raceTrack[currRow][currCol] == 'T') {
            moveThroughTunel(currRow, currCol);
        } else {
            standardMove(currRow, currCol);
        }
    }

    private static void printResults() {
        StringBuilder strBld = new StringBuilder();
        strBld.append(
                (raceFinished)
                        ? String.format("Racing car %s finished the stage!%n", carNumber)
                        : String.format("Racing car %s DNF.%n", carNumber));
        strBld.append(String.format("Distance covered %d km.%n", distanceCovered));
        for (char[] row : raceTrack) {
            strBld.append(row).append(System.lineSeparator());
        }
        System.out.print(strBld);
    }

    private static void moveThroughTunel(int currRow, int currCol) {
        raceTrack[currRow][currCol] = '.';
        for (int r = 0; r < side; r++) {
            for (int c = 0; c < side; c++) {
                if (raceTrack[r][c] == 'T') {
                    carPosRow = r;
                    carPosCol = c;
                    distanceCovered += 30;
                    raceTrack[r][c] = '.';
                }
            }

        }
    }

    private static void standardMove(int currRow, int currCol) {
        distanceCovered += 10;
        carPosRow = currRow;
        carPosCol = currCol;
        if (raceTrack[currRow][currCol] == 'F') {
            raceFinished = true;
        }
        raceTrack[carPosRow][carPosCol] = 'C';
    }
}
