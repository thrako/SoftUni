package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String msg;
        while (!"Home".equals(input)) {
            if (!"back".equals(input)) {
                stack.push(input);
                System.out.println(stack.peek());
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
            input = scanner.nextLine();
        }
    }
}
