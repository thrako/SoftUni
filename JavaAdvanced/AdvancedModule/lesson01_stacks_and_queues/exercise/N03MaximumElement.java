package lesson01_stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class N03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsCount = Integer.parseInt(scanner.nextLine());
        Deque<Integer> maximums = new ArrayDeque<>();
        for (int i = 0; i < commandsCount; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String command = inputData[0];
            switch (command) {
                case "1":
                    int number = Integer.parseInt(inputData[1]);
                    if (!maximums.isEmpty() && number < maximums.peek()) {
                        maximums.push(maximums.peek());
                    } else {
                        maximums.push(number);
                    }
                    break;
                case "2":
                    maximums.pop();
                    break;
                case "3":
                    System.out.println(maximums.peek());
                    break;
                default:
            }
        }
    }
}
