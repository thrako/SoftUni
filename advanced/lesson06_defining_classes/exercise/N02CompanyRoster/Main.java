package lesson06_defining_classes.exercise.N02CompanyRoster;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<String, Department> departments = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = new Employee(name, salary, position, department);
            if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    employee.addEmail(email);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    employee.addAge(age);
                }
            }
            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee.addEmail(email).addAge(age);
            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).addEmployee(employee);
        }
        var highestAvgSalaryDep = departments.values().stream()
                .max(Comparator.comparing(Department::getAverageSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.printf("Highest Average Salary: %s%n", highestAvgSalaryDep.getName());
        highestAvgSalaryDep.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
