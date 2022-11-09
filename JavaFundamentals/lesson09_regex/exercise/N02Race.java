package lesson09_regex.exercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02Race {
    private static final String END = "end of race";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> participants = new LinkedHashMap<>();
        for (String participant : scanner.nextLine().split(",\\s+")) {
            participants.put(participant, 0);
        }

        String input = scanner.nextLine();
        while (!END.equals(input)) {
            String name = getName(input);
            int sum = getSum(input);

            Integer currDistance = participants.get(name);
            if (currDistance != null) participants.put(name, currDistance + sum);

            input = scanner.nextLine();
        }

        printPrized(participants);
    }

    private static String getName(String input) {
        Pattern letterPattern = Pattern.compile("[A-Za-z]+");
        StringBuilder strBld = new StringBuilder();
        Matcher matcher = letterPattern.matcher(input);
        while (matcher.find()) strBld.append(matcher.group());
        return strBld.toString();
    }

    private static int getSum(String input) {
        Pattern digitPattern = Pattern.compile("[0-9]");
        int sum = 0;
        Matcher matcher = digitPattern.matcher(input);
        while (matcher.find()) sum += Integer.parseInt(matcher.group());
        return sum;
    }

    private static void printPrized(Map<String, Integer> participants) {
        Object[] prized = participants.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toArray();

        if (prized.length > 0) System.out.printf("1st place: %s%n", prized[0]);
        if (prized.length > 1) System.out.printf("2nd place: %s%n", prized[1]);
        if (prized.length > 2) System.out.printf("3rd place: %s%n", prized[2]);
    }
}
