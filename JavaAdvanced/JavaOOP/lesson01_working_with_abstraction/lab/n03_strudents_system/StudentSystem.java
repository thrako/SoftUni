package lesson01_working_with_abstraction.lab.n03_strudents_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StudentSystem {

    private static final String STUDENT_FORMAT = "%s is %s years old. %s";
    private static final String EXCELLENT_STUDENT = "Excellent student.";
    private static final String AVERAGE_STUDENT = "Average student.";
    private static final String NICE_PERSON = "Very nice person.";

    private final Map<String, Student> studentsRepo;

    public StudentSystem() {
        this.studentsRepo = new HashMap<>();
    }

    public void show(String name) {

        Optional<Student> optionalStudent = Optional.ofNullable(studentsRepo.get(name));
        optionalStudent.ifPresent(this::printInfo);
    }

    private void printInfo(Student student) {
        System.out.printf(STUDENT_FORMAT + "%n",
                student.getName(), student.getAge(), getComment(student.getGrade()));
    }

    private String getComment(double studentGrade) {
        if (studentGrade >= 5.00) {
            return EXCELLENT_STUDENT;
        } else if (studentGrade >= 3.50) {
            return AVERAGE_STUDENT;
        } else {
            return NICE_PERSON;
        }
    }

    public void createStudent(String name, int age, double grade) {
        studentsRepo.putIfAbsent(name, new Student(name, age, grade));
    }
}
