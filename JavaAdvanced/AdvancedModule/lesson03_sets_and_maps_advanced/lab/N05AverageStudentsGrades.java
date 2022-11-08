package lesson03_sets_and_maps_advanced.lab;

import java.util.*;
import java.util.stream.Collectors;

public class N05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGradesMap = new TreeMap<>();
        int inputsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputsCount; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            Double grade = Double.parseDouble(inputData[1]);
            studentGradesMap.putIfAbsent(name, new ArrayList<>());
            studentGradesMap.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentGradesMap.entrySet()) {
            double avgGradeSum = 0;
            for (Double grade : entry.getValue()) {
                avgGradeSum += grade;
            }

            System.out.printf("%s -> %s (avg: %.2f)%n",
                    entry.getKey(),
                    entry.getValue().stream()
                            .map(d -> String.format("%.2f", d))
                            .collect(Collectors.joining(" ")),
                    //.summaryStatistics().getAverage() does not pass all tests
                   avgGradeSum / entry.getValue().size()
            );
        }
    }
}
