package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!"print".equals(input)) {
            if ("cancel".equals(input)) {
                if (queue.size() > 0) System.out.println("Canceled " + queue.pollFirst());
                else System.out.println("Printer is on standby");
            } else queue.offer(input);
            input = scanner.nextLine();
        }

        while (queue.size() > 0) System.out.println(queue.pollFirst());
    }
}
