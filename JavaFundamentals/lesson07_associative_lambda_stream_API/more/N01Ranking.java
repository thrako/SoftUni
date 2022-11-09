package lesson07_associative_lambda_stream_API.more;

import java.util.*;
import java.util.stream.Collectors;

public class N01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new HashMap<>();
        String[] tokens = scanner.nextLine().split(":");
        while (!"end of contests".equals(tokens[0])) {
            String contestName = tokens[0];
            String password = tokens[1];
            if (!contests.containsKey(contestName)) {
                contests.put(contestName, password);
                tokens = scanner.nextLine().split(":");
            }
        }

        Map<String, Map<String, Integer>> students = new LinkedHashMap<>();
        tokens = scanner.nextLine().split("=>");
        while (!"end of submissions".equals(tokens[0])) {
            String contestName = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            Integer points = Integer.parseInt(tokens[3]);

            if (contests.containsKey(contestName) && contests.get(contestName).equals(password)) {

                if (!students.containsKey(username)) {
                    Map<String, Integer> exams = new LinkedHashMap<>();
                    exams.put(contestName, points);
                    students.put(username, exams);
                } else {
                    String sameContest = students.get(username).keySet().stream()
                            .filter(e -> e.equals(contestName))
                            .findFirst().orElse(null);

                    if (sameContest == null) {
                        students.get(username).put(contestName, points);
                    } else {

                        if (students.get(username).get(contestName) < points) {
                            students.get(username).put(contestName, points);
                        }
                    }
                }
            }
            tokens = scanner.nextLine().split("=>");
        }

        Map.Entry<String, Integer> best = students.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        stringMapEntry -> stringMapEntry.getValue().values()
                                .stream()
                                .reduce(Integer::sum).orElse(0),
                        (e1, e2) -> e1,
                        LinkedHashMap::new))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).orElse(null);

        if (best != null) {
            System.out.printf(
                    "Best candidate is %s with total %d points.%n" +
                    "Ranking:%n"
                    , best.getKey(), best.getValue()
            );
            printSorted(students);
        }
    }

    private static void printSorted(Map<String, Map<String, Integer>> students) {
        students.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .forEach(N01Ranking::printData);
    }

    private static void printData(String studentName, Map<String, Integer> exams) {
        System.out.println(studentName);
        exams.entrySet().stream()
                .sorted((Collections.reverseOrder(Map.Entry.comparingByValue())))
                .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
    }
}

