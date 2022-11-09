package lesson07_associative_lambda_stream_API.more;

import java.util.*;
import java.util.stream.Collectors;

public class N02Judge {
    private static final String END = "no more time";
    private static final int[] counter = {0};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> contestMapUsersPoints = new LinkedHashMap<>();
        Map<String, List<String>> userListContests = new LinkedHashMap<>();

        consoleFill(scanner, contestMapUsersPoints, userListContests);
        printContests(contestMapUsersPoints);
        printIndividualStandings(contestMapUsersPoints, userListContests);
    }

    private static void consoleFill(Scanner scanner, Map<String, Map<String, Integer>> contestMapUsersPoints, Map<String, List<String>> userListContests) {
        String user, contest, input = scanner.nextLine();
        String[] tokens;
        int points, oldPoints;

        while (!END.equals(input)) {
            tokens = input.split(" -> ");
            user = tokens[0];
            contest = tokens[1];
            points = Integer.parseInt(tokens[2]);

            userListContests.putIfAbsent(user, new ArrayList<>());
            if (!userListContests.get(user).contains(contest)) userListContests.get(user).add(contest);

            contestMapUsersPoints.putIfAbsent(contest, new LinkedHashMap<>());
            oldPoints = contestMapUsersPoints.get(contest).getOrDefault(user, -1);
            if (oldPoints < points) contestMapUsersPoints.get(contest).put(user, points);

            input = scanner.nextLine();
        }
    }

    private static void printContests(Map<String, Map<String, Integer>> contestMapUsersPoints) {
        contestMapUsersPoints.forEach((key, value) -> {
            resetCounter();
            System.out.printf("%s: %d participants%n", key, value.size());
            value.entrySet()
                    .stream()
                    .sorted(N02Judge::compareDescAbc)
                    .forEach(e -> System.out.printf(
                            "%d. %s <::> %d%n",
                            ++counter[0], e.getKey(), e.getValue()
                    ));
        });
    }

    private static void printIndividualStandings(Map<String, Map<String, Integer>> contestMapUsersPoints, Map<String, List<String>> userListContests) {
        System.out.println("Individual standings:");
        resetCounter();
        userListContests.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue()
                                .stream()
                                .filter(contestMapUsersPoints::containsKey)
                                .mapToInt(contest -> contestMapUsersPoints.get(contest).get(e.getKey()))
                                .reduce(Integer::sum).orElse(0),
                        (e1, e2) -> e1,
                        LinkedHashMap::new)).entrySet()
                .stream()
                .sorted(N02Judge::compareDescAbc)
                .forEach(e -> System.out.printf(
                        "%d. %s -> %d%n",
                        ++counter[0], e.getKey(), e.getValue()
                ));
    }

    private static void resetCounter() {
        counter[0] = 0;
    }

    private static int compareDescAbc(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() < e2.getValue()) return 1;
        if (e1.getValue() > e2.getValue()) return -1;
        return e1.getKey().compareToIgnoreCase(e2.getKey());
    }
}
