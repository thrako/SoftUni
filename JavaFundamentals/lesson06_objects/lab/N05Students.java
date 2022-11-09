package lesson06_objects.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N05Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        Student student;
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            student = new Student(input.split("\\s+"));
            students.add(student);
            input = scanner.nextLine();
        }

        String cityName = scanner.nextLine();
        students.stream().filter(e -> cityName.equals(e.getHometown())).forEach(e -> System.out.println(e.getIntro()));
    }

    static class Student {
        private final String fname;
        private final String lname;
        private final int age;
        private final String hometown;

        public Student(String[] args) {
            this.fname = args[0];
            this.lname = args[1];
            this.age = Integer.parseInt(args[2]);
            this.hometown = args[3];
        }

        public String getHometown() {
            return hometown;
        }

        public String getIntro() {
            return String.format("%s %s is %d years old", fname, lname, age);
        }
    }
}
