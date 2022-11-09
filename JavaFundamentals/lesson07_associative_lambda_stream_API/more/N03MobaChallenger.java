package lesson07_associative_lambda_stream_API.more;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class N03MobaChallenger {
    private static final String END = "Season end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> seasonStats = getStatsFromConsole(scanner);
        printSorted(seasonStats);
    }

    private static Map<String, Map<String, Integer>> getStatsFromConsole(Scanner scanner) {
        Map<String, Map<String, Integer>> seasonStats = new HashMap<>();
        String input = scanner.nextLine();

        while (!END.equals(input)) {
            if (input.contains(" -> ")) {
                String[] tokens = input.split(" -> ");
                String name = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                update(seasonStats, name, position, skill);

            } else if (input.contains(" vs ")) {
                String[] tokens = input.split(" vs ");
                String firstPlayerName = tokens[0];
                String secondPlayerName = tokens[1];

                duel(seasonStats, firstPlayerName, secondPlayerName);
            }
            input = scanner.nextLine();
        }
        return seasonStats;
    }

    private static void update(Map<String, Map<String, Integer>> seasonStats, String name, String position, int skill) {
        Map<String, Integer> mapPositionSkill = seasonStats.getOrDefault(name, new HashMap<>());
        seasonStats.putIfAbsent(name, mapPositionSkill);

        Integer currentSkill = mapPositionSkill.getOrDefault(position, 0);
        if (currentSkill < skill) mapPositionSkill.put(position, skill);
    }

    private static void duel(Map<String, Map<String, Integer>> seasonStats, String firstPlayerName, String secondPlayerName) {
        Map<String, Integer> firstPlayerPositions = seasonStats.get(firstPlayerName);
        Map<String, Integer> secondPlayerPositions = seasonStats.get(secondPlayerName);
        if (firstPlayerPositions != null && secondPlayerPositions != null) {
            firstPlayerPositions.entrySet().stream()
                    .filter(e -> secondPlayerPositions.containsKey(e.getKey()))
                    .findAny()
                    .ifPresent(e -> {
                        int firstSkill = seasonStats.get(firstPlayerName).values().stream().reduce(Integer::sum).orElse(0);
                        int secondSkill = seasonStats.get(secondPlayerName).values().stream().reduce(Integer::sum).orElse(0);
                        if (firstSkill > secondSkill) {
                            seasonStats.remove(secondPlayerName);
                        } else if (firstSkill < secondSkill) {
                            seasonStats.remove(firstPlayerName);
                        }
                    });
        }
    }

    private static void printSorted(Map<String, Map<String, Integer>> seasonStats) {
        seasonStats.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    int points1 = entry1.getValue().values().stream().reduce(Integer::sum).orElse(0);
                    int points2 = entry2.getValue().values().stream().reduce(Integer::sum).orElse(0);
                    String name1 = entry1.getKey();
                    String name2 = entry2.getKey();
                    if (points1 == points2)
                        return name1.compareToIgnoreCase(name2);
                    else
                        return Integer.compare(points2, points1);
                })
                .forEach(entry -> {
                    String name = entry.getKey();
                    int totalPoints = entry.getValue().values().stream().reduce(Integer::sum).orElse(0);
                    System.out.printf("%s: %d skill%n", name, totalPoints);
                    entry.getValue().entrySet()
                            .stream()
                            .sorted((entry1, entry2) -> {
                                int skill1 = entry1.getValue();
                                int skill2 = entry2.getValue();
                                if (Objects.equals(skill1, skill2))
                                    return entry1.getKey().compareToIgnoreCase(entry2.getKey());
                                else
                                    return Integer.compare(skill2, skill1);
                            })
                            .forEach((e) -> System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue()));
                });
    }
}
