package lesson05_functional_programming.exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class N11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> filters = new HashMap<>();
        String input = scanner.nextLine();
        while (!"Print".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            switch (command) {
                case "Add filter": {
                    String name = tokens[1] + tokens[2];
                    filters.put(name, getPredicate(tokens[1], tokens[2]));
                    break;
                }
                case "Remove filter": {
                    String name = tokens[1] + tokens[2];
                    filters.remove(name);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            input = scanner.nextLine();
        }

        Predicate<String> combinedFilter = filters.values().stream().reduce(Predicate::or).orElse(x -> false);
        System.out.println(
                guests.stream()
                        .filter(x -> !combinedFilter.test(x))
                        .collect(Collectors.joining(" "))
        );
    }

    private static Predicate<String> getPredicate(String condition, String value) {
        switch (condition) {
            case "Starts with":
                return s -> s.startsWith(value);

            case "Ends with":
                return s -> s.endsWith(value);

            case "Length":
                return s -> s.length() == Integer.parseInt(value);

            case "Contains":
                return s -> s.contains(value);

            default:
                throw new IllegalStateException("Unexpected value: " + condition);
        }
    }
}
