package my_exams.fin20220807;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N03MessagesManager_lazy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> users = new LinkedHashMap<>();
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
                    users.putIfAbsent(username, sent + received);
                    break;
                }
                case "Message": {
                    var sender = tokens[++counter];
                    var receiver = tokens[++counter];
                    if (users.containsKey(sender) && users.containsKey(receiver)) {
                        users.put(sender, users.get(sender) + 1);
                        users.put(receiver, users.get(receiver) + 1);

                        if (users.get(sender) >= capacity) {
                            removeUser(sender, users);
                        }

                        if (users.get(receiver) >= capacity) {
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
        users.forEach((name, messagesCount) -> System.out.printf("%s - %d%n", name, messagesCount));
    }

    private static void removeUser(String sender, Map<String, Integer> users) {
        System.out.printf("%s reached the capacity!%n", sender);
        users.remove(sender);
    }

}
