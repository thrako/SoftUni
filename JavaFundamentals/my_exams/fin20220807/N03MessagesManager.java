package my_exams.fin20220807;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N03MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> users = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("=");
            int counter = -1;
            String command = tokens[++counter];
            switch (command) {
                case "Add": {
                    String username = tokens[++counter];
                    int sent = Integer.parseInt(tokens[++counter]);
                    int received = Integer.parseInt(tokens[++counter]);
                    users.putIfAbsent(username, new int[]{sent, received});
                    break;
                }
                case "Message": {
                    var sender = tokens[++counter];
                    var receiver = tokens[++counter];
                    if (users.containsKey(sender) && users.containsKey(receiver)) {
                        users.get(sender)[0] += 1;
                        users.get(receiver)[1] += 1;

                        if (hasReachedCapacity(users.get(sender), capacity)) {
                            removeUser(sender, users);
                        }

                        if (hasReachedCapacity(users.get(receiver), capacity)) {
                            removeUser(receiver, users);
                        }
                    }
                    break;
                }
                case "Empty": {
                    String username = tokens[++counter];
                    if ("All".equals(username)) {
                        users = new LinkedHashMap<>();
                    } else {
                        users.remove(username);
                    }
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Users count: %d%n", users.size());
        users.forEach((name, messages) -> System.out.printf("%s - %d%n", name, messages[0] + messages[1]));
    }

    private static void removeUser(String sender, Map<String, int[]> users) {
        System.out.printf("%s reached the capacity!%n", sender);
        users.remove(sender);
    }

    private static boolean hasReachedCapacity(int[] messages, int capacity) {
        return messages[0] + messages[1] >= capacity;
    }
}
