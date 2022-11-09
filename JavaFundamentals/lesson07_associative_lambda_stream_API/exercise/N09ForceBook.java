package lesson07_associative_lambda_stream_API.exercise;

import java.util.*;

public class N09ForceBook {
    private static final String END = "Lumpawaroo";
    public static void main(String[] args) {
        Map<String, List<String>> sideUserlist = new LinkedHashMap<>();
        Map<String, String> userSide = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String side, user, input = scanner.nextLine();
        String[] tokens;
        while (!END.equals(input)) {
            if (input.contains(" | ")) {
                tokens = input.split(" \\| ");
                side = tokens[0];
                user = tokens[1];

                if (userSide.containsKey(user)) break;
                sideUserlist.putIfAbsent(side, new ArrayList<>());
                sideUserlist.get(side).add(user);
                userSide.put(user, side);
            } else if (input.contains(" -> ")) {
                tokens = input.split(" -> ");
                user = tokens[0];
                side = tokens[1];

                if (userSide.containsKey(user)) {
                    String oldSide = userSide.get(user);
                    sideUserlist.get(oldSide).remove(user);
                }
                sideUserlist.putIfAbsent(side, new ArrayList<>());
                sideUserlist.get(side).add(user);
                userSide.put(user, side);
                System.out.printf("%s joins the %s side!%n", user, side);
            }
            input = scanner.nextLine();
        }

        sideUserlist.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> printFormatted(entry));

    }

    private static void printFormatted(Map.Entry<String, List<String>> entry) {
        List<String> users = entry.getValue();
        System.out.printf("Side: %s, Members: %d%n", entry.getKey(), users.size());
        for (String user : users) {
            System.out.printf("! %s%n", user);
        }
    }
}
