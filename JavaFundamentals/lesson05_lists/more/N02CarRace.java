package lesson05_lists.more;

import java.util.*;
import java.util.stream.IntStream;

public class N02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] raceTimes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = raceTimes.length;
        int finishLineIdx = length / 2;

        int[] leftRacerTimes = Arrays.copyOfRange(raceTimes, 0, finishLineIdx);
        int[] rightRacerTimes = IntStream.range(0, finishLineIdx).map(i -> raceTimes[length - 1 - i]).toArray();

        double leftTotalTime = calculateTime(leftRacerTimes);
        double rightTotalTime = calculateTime(rightRacerTimes);

        if (leftTotalTime < rightTotalTime) {
            System.out.printf("The winner is left with total time: %.1f", leftTotalTime);
        } else if (rightTotalTime < leftTotalTime) {
            System.out.printf("The winner is right with total time: %.1f", rightTotalTime);
        }
    }

    private static double calculateTime(int[] loops) {
        double time = 0;
        for (int loop : loops) {
            if (loop == 0) {
                time *= (1 - 0.2);
            } else {
                time += loop;
            }
        }
        return time;
    }

    private static void reverse(int[] array) {
        for (int i = 0, temp, length = array.length; i < length / 2; i++) {
            temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }
}
