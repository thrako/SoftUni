package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> group = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int num = Integer.parseInt(scanner.nextLine());
        int cycle = 1;
        while (group.size() > 1) {

            for (int i = 1; i < num; i++) {
                //noinspection ConstantConditions
                group.offer(group.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + group.peek());
            } else {
                System.out.println("Removed " + group.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + group.peek());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
