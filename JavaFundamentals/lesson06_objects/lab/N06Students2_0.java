package lesson06_objects.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N06Students2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] newStudentData = input.split("\\s+");
            Student newStudent = new Student(newStudentData);
            Student existingStudent = find(students, newStudent.getFirstName(), newStudent.getLastName());
            if (existingStudent != null) {
                existingStudent.setAge(newStudent.getAge());
                existingStudent.setHometown(newStudent.getHometown());
            } else {
                students.add(newStudent);
            }
            input = scanner.nextLine();
        }
        String cityName = scanner.nextLine();
        students.stream().filter(e -> cityName.equals(e.getHometown())).forEach(e -> System.out.println(e.getIntro()));
    }

    private static Student find(List<Student> students, String newFirstName, String newLastName) {
        return students.stream()
                .filter(e -> e.getFirstName().equals(newFirstName) && e.getLastName().equals(newLastName))
                .findFirst()
                .orElse(null);
    }

    static class Student {
        private final String firstName;
        private final String lastName;
        private int age;
        private String hometown;

        public Student(String[] args) {
            this.firstName = args[0];
            this.lastName = args[1];
            this.age = Integer.parseInt(args[2]);
            this.hometown = args[3];
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public String getIntro() {
            return String.format(
                    "%s %s is %d years old",
                    this.firstName, this.lastName, this.age
            );
        }
    }
}
