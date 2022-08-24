package lesson03_sets_and_maps_advanced.exercise;

import java.util.*;

public class N08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> userIPMap = new TreeMap<>();
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] inputData = input.split("\\s+");
            String ip = inputData[0].split("=")[1];
            String username = inputData[2].split("=")[1];
            userIPMap.putIfAbsent(username, new LinkedHashMap<>());
            userIPMap.get(username).putIfAbsent(ip, 0);
            int increasedCount = userIPMap.get(username).get(ip) + 1;
            userIPMap.get(username).put(ip, increasedCount);
            input = scanner.nextLine();
        }

        for (var entry : userIPMap.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            List<String> ipAddresses = new ArrayList<>();
            entry.getValue().forEach((key, value) -> ipAddresses.add(key + " => " + value));
            System.out.println(String.join(", ", ipAddresses) + ".");
        }
    }
}
