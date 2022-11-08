package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int sum = 0;
        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int second = Integer.parseInt(stack.pop());
            if ("+".equals(sign)) {
                sum = first + second;
            } else if ("-".equals(sign)) {
                sum = first - second;
            }
            stack.push(String.valueOf(sum));
        }
        System.out.println(stack.peek());
    }
}
