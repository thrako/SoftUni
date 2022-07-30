package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> group = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int num = Integer.parseInt(scanner.nextLine());
        while (group.size() > 1) {
            for (int i = 1; i < num; i++) {
                //noinspection ConstantConditions
                group.offer(group.poll());
            }
            System.out.println("Removed " + group.poll());
        }
        System.out.println("Last is " + group.peek());
    }
}
