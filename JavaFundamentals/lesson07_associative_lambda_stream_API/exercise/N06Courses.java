package lesson07_associative_lambda_stream_API.exercise;

import java.util.*;

public class N06Courses {
    public static void main(String[] args) {
        Map<String, List<String>> courseStudents = new LinkedHashMap<>();
        consoleFill(courseStudents);
        printFormatted(courseStudents);
    }

    private static void consoleFill(Map<String, List<String>> courseStudents) {
        Scanner scanner = new Scanner(System.in);
        String course, student, input = scanner.nextLine();
        String[] tokens;

        while (!"end".equals(input)) {
            tokens = input.split(" : ");
            course = tokens[0];
            student = tokens[1];

            courseStudents.putIfAbsent(course, new ArrayList<>());
            courseStudents.get(course).add(student);

            input = scanner.nextLine();
        }
    }

    private static void printFormatted(Map<String, List<String>> courseStudents) {
        List<String> students;
        for (Map.Entry<String, List<String>> entry : courseStudents.entrySet()) {
            students = entry.getValue();
            System.out.printf("%s: %d%n", entry.getKey(), students.size());
            for (String student : students) {
                System.out.printf("-- %s%n", student);
            }
        }
    }
}
