package lesson01_stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class N02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> stack = new ArrayDeque<>();

        int numbersToTake = (inputData[0] > inputData[1])
                ? inputData[0] - inputData[1]
                : 0;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numbersToTake)
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            int soughtElement = inputData[2];
            int foundOrMin = getSoughtOrMin(soughtElement, stack);
            System.out.println((foundOrMin == soughtElement)
                    ? "true"
                    : foundOrMin);
        }

    }

    private static int getSoughtOrMin(int soughtElement, Deque<Integer> stack) {
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int number = stack.pop();
            if (number == soughtElement) return soughtElement;
            else if (number < min) min = number;
        }
        return min;
    }
}
