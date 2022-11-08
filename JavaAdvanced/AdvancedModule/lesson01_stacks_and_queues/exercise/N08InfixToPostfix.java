package lesson01_stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class N08InfixToPostfix {
    private static final String OPERATORS = "+-*/";

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String[] symbols = scanner.nextLine().split("\\s+");
        for (String symbol : symbols) {
            if (isOperator(symbol)) {
                while (!stack.isEmpty() && !hasGreaterPrecedence(symbol, stack.peek())) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(symbol);
            } else if ("(".equals(symbol)) {
                stack.push(symbol);
            } else if (")".equals(symbol)) {
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    output.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) stack.pop();
            } else {
                output.append(symbol).append(" ");
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }
        System.out.println(output.toString().trim());
    }

    private static boolean isOperator(String symbol) {
        return OPERATORS.contains(symbol);
    }

    private static boolean hasGreaterPrecedence(String symbol, String peeked) {
        return getPrecedence(symbol) > getPrecedence(peeked);
    }

    private static int getPrecedence(String symbol) {
        int idx = OPERATORS.indexOf(symbol);
        if (idx == 0 || idx == 1) return 10;
        if (idx == 2 || idx == 3) return 200;
        return -1;

    }
}
