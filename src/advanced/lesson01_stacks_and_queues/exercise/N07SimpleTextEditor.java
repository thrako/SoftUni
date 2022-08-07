package lesson01_stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class N07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> history = new ArrayDeque<>();
        StringBuilder strBld = new StringBuilder();
        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            switch (commands[0]) {
                case "1":
                    strBld.append(commands[1]);
                    history.push(strBld.toString());
                    break;
                case "2":
                    int length = strBld.length();
                    int reduction = Integer.parseInt(commands[1]);
                    strBld.delete(length - reduction, length);
                    history.push(strBld.toString());
                    break;
                case "3":
                    int idx = Integer.parseInt(commands[1]) - 1;
                    System.out.println(strBld.charAt(idx));
                    break;
                case "4":
                    strBld.setLength(0);
                    if (history.size() > 1) {
                        history.pop();
                        strBld.append(history.peek());
                    }
                    break;
                default:
            }
        }
    }
}
