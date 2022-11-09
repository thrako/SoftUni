package lesson07_associative_lambda_stream_API.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N10SoftUniExamResults {
    private static final String END = "exam finished";

    public static void main(String[] args) {
        Map<String, Integer> userPoints = new LinkedHashMap<>();
        Map<String, Integer> langSubmissions = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String user, language, input = scanner.nextLine();
        String[] tokens;
        Integer points, oldPoints;

        while (!END.equals(input)) {
            tokens = input.split("-");
            user = tokens[0];

            if (tokens.length == 2 && tokens[1].equals("banned")) {
                userPoints.remove(user);
                input = scanner.nextLine();
                continue;
            }

            language = tokens[1];
            points = Integer.parseInt(tokens[2]);
            oldPoints = userPoints.get(user);
            if (oldPoints == null || oldPoints < points) {
                userPoints.put(user, points);
            }
            langSubmissions.put(language, langSubmissions.get(language) == null
                    ? 1
                    : langSubmissions.get(language) + 1);

            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : userPoints.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : langSubmissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
