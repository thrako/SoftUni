package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0, length = input.length(); i < length; i++) {
            if (input.charAt(i) == '(' ) {
                stack.push(i);
            }
            if (input.charAt(i) == ')' ) {
                int startIdx = stack.pop();
                String expression = input.substring(startIdx, i + 1);
                System.out.println(expression);
            }
        }
    }
}
