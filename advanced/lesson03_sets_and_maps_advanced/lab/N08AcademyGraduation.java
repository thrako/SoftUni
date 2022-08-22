package lesson03_sets_and_maps_advanced.lab;

import java.util.*;
import java.util.stream.Collectors;

public class N08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputsCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();
        for (int i = 0; i < inputsCount; i++) {
            String name = scanner.nextLine();
            ArrayList<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toCollection(ArrayList::new));
            studentGrades.put(name, grades);
        }

        studentGrades.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    var avgGrade = entry.getValue().stream().reduce(Double::sum).orElse(0d) / entry.getValue().size();
                    System.out.println( entry.getKey() + " is graduated with "+ avgGrade);
                });
    }
}
