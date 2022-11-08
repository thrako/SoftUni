package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> nextStack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String current;
        while (!"Home".equals(input)) {
            if ("back".equals(input)) {
                if (backStack.size() > 1) {
                    current = backStack.pop();
                    nextStack.push(current);
                    System.out.println(backStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals(input)) {
                if (!nextStack.isEmpty()) {
                    current = nextStack.pop();
                    backStack.push(current);
                    System.out.println(current);
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                current = input;
                backStack.push(current);
                System.out.println(current);
                nextStack.clear();
            }
            input = scanner.nextLine();
        }
    }
}
