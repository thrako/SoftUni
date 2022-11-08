package lesson03_sets_and_maps_advanced.exercise;

import java.util.*;

public class N10LogsAggregator_MapStringObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, User> users = new TreeMap<>();
        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String ipAddress = inputData[0];
            String name = inputData[1];
            int time = Integer.parseInt(inputData[2]);
            users.putIfAbsent(name, new User(name));
            users.get(name).addIpAddress(ipAddress).addTime(time);
        }
        users.values().forEach(System.out::println);
    }

    private static class User {
        private final String name;
        private final Set<String> ipAddresses;
        private int totalTime;

        public User(String name) {
            this.name = name;
            this.ipAddresses = new TreeSet<>();
            this.totalTime = 0;
        }

        public User addIpAddress(String ipAddress) {
            this.ipAddresses.add(ipAddress);
            return this;
        }

        public User addTime(int time) {
            this.totalTime += time;
            return this;
        }

        @Override
        public String toString() {
            return String.format("%s: %d %s", this.name, this.totalTime, this.ipAddresses);
        }
    }
}
