package lesson01_stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class N04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Queue<Integer> queue = new ArrayDeque<>();

        int numbersToOffer = inputData[0];
        int numbersToPoll = inputData[1];

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numbersToOffer)
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        IntStream.range(0, numbersToPoll).forEach(i -> queue.poll());

        if (!queue.isEmpty()) {
            int soughtElement = inputData[2];
            int foundOrMin = getSoughtOrMin(soughtElement, queue);
            System.out.println((foundOrMin == soughtElement)
                    ? "true"
                    : foundOrMin);
        } else {
            System.out.println("0");
        }
    }

    private static int getSoughtOrMin(int soughtElement, Queue<Integer> queue) {
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int number = queue.poll();
            if (number == soughtElement) return soughtElement;
            else if (number < min) min = number;
        }
        return min;
    }
}
