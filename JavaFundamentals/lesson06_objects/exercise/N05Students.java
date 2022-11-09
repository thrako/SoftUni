package lesson06_objects.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class N05Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        int studentsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentsCount; i++) {
            studentList.add(new Student(scanner.nextLine().split(" ")));
        }
        studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade)
                        .reversed())
                .forEach(System.out::println);
    }

    private static class Student {
        private final String firstName;
        private final String secondName;
        private final double grade;


        public Student(String[] args) {
            this.firstName = args[0];
            this.secondName = args[1];
            this.grade = Double.parseDouble(args[2]);
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s %s: %.2f",
                    firstName, secondName, grade
            );
        }
    }
}
