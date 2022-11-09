package lesson07_associative_lambda_stream_API.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N07StudentAcademy {
    public static void main(String[] args) {
        Map<String, List<Double>> stdGrades = new LinkedHashMap<>();
        consoleFill(stdGrades);
        printFiltered(stdGrades, 4.5);
    }

    private static void printFiltered(Map<String, List<Double>> stdGrades, double threshold) {
        stdGrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().reduce(Double::sum).orElse((double) 0) / entry.getValue().size(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                )).entrySet().stream()
                .filter(entry -> entry.getValue() >= threshold)
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }

    private static void consoleFill(Map<String, List<Double>> stdGrades) {
        Scanner scanner = new Scanner(System.in);
        int numInputs = Integer.parseInt(scanner.nextLine());
        String name;
        double grade;

        for (int i = 0; i < numInputs; i++) {
            name = scanner.nextLine();
            grade = Double.parseDouble(scanner.nextLine());
            stdGrades.putIfAbsent(name, new ArrayList<>());
            stdGrades.get(name).add(grade);
        }
    }
}
