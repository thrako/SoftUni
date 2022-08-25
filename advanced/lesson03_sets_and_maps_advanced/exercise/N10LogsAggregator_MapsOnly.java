package lesson03_sets_and_maps_advanced.exercise;

import java.util.*;

public class N10LogsAggregator_MapsOnly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> userAddresses = new TreeMap<>();
        Map<String, Integer> userTotalTime = new TreeMap<>();
        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String ipAddress = inputData[0];
            String name = inputData[1];
            int time = Integer.parseInt(inputData[2]);
            userAddresses.putIfAbsent(name, new TreeSet<>());
            userAddresses.get(name).add(ipAddress);
            userTotalTime.putIfAbsent(name, 0);
            int subTotalTime = userTotalTime.get(name);
            userTotalTime.put(name, subTotalTime + time);
        }

        for (String name : userAddresses.keySet()) {
            System.out.printf("%s: %d %s%n", name, userTotalTime.get(name), userAddresses.get(name));
        }
    }
}
