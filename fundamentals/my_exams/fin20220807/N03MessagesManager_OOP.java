package my_exams.fin20220807;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N03MessagesManager_OOP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        Messenger messenger = new Messenger(capacity);
        MessageManager manager = new MessageManager(messenger);
        String input = scanner.nextLine();
        while (!"Statistics".equals(input)) {
            manager.processCommand(input);
            input = scanner.nextLine();
        }
        messenger.printStatistics();
    }

    private static class Messenger {
        private final int capacity;
        private Map<String, User> users;

        public Messenger(int capacity) {
            this.capacity = capacity;
            this.users = new LinkedHashMap<>();
        }

        public void add(User user) {
            this.users.putIfAbsent(user.getName(), user);
        }

        public void registerMessage(String senderName, String receiverName) {
            User sender = this.getUser(senderName);
            User receiver = this.getUser(receiverName);
            if (sender == null || receiver == null) return;
            sender.send();
            receiver.receive();
            if (hasReachedCapacity(sender)) remove(sender.getName());
            if (hasReachedCapacity(receiver)) remove(receiver.getName());

        }

        public User getUser(String name) {
            return this.users.get(name);
        }

        private boolean hasReachedCapacity(User user) {
            if (user.getTotalMessages() >= this.capacity) {
                System.out.printf("%s reached the capacity!%n", user.getName());
                return true;
            }
            return false;
        }

        public void remove(String username) {
            this.users.remove(username);
        }

        public void reset() {
            this.users = new LinkedHashMap<>();
        }

        public void printStatistics() {
            System.out.printf("Users count: %d%n", this.users.size());
            this.users.values().forEach(System.out::println);
        }
    }

    private static class MessageManager {
        private final Messenger messenger;

        public MessageManager(Messenger messenger) {
            this.messenger = messenger;
        }

        public void processCommand(String input) {
            String[] tokens = input.split("=");
            int counter = -1;
            String command = tokens[++counter];
            switch (command) {
                case "Add": {
                    String username = tokens[++counter];
                    int sent = Integer.parseInt(tokens[++counter]);
                    int received = Integer.parseInt(tokens[++counter]);
                    this.messenger.add(new User(username, sent, received));
                    break;
                }
                case "Message": {
                    String senderName = tokens[++counter];
                    String receiverName = tokens[++counter];
                    this.messenger.registerMessage(senderName, receiverName);
                    break;
                }
                case "Empty": {
                    String username = tokens[++counter];
                    if ("All".equals(username)) this.messenger.reset();
                    else this.messenger.remove(username);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }

    private static class User {
        private final String name;
        private int sent;
        private int received;

        public User(String name, int sent, int received) {
            this.name = name;
            this.sent = sent;
            this.received = received;
        }

        public void send() {
            this.sent += 1;
        }

        public void receive() {
            this.received += 1;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.getTotalMessages());
        }

        public int getTotalMessages() {
            return this.sent + this.received;
        }
    }
}
