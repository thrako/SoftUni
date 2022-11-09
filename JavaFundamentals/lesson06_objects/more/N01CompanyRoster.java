package lesson06_objects.more;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class N01CompanyRoster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeesCount = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>(employeesCount);
        processInputData(scanner, employeesCount, departments);
        printHighestPaidDep(departments);
    }

    private static void processInputData(Scanner scanner, int employeesCount, List<Department> departments) {
        for (int i = 0; i < employeesCount; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            Employee employee = buildEmployee(employeeData);
            Department department = departments.stream()
                    .filter(d -> d.getName().equals(employee.getDepartment()))
                    .findFirst()
                    .orElse(null);
            if (department == null) {
                department = new Department(employee.getDepartment());
                departments.add(department);
            }
            department.add(employee);

        }
    }

    private static void printHighestPaidDep(List<Department> departments) {
        departments.stream()
                .max(Comparator.comparingDouble(Department::getAvgSalary))
                .ifPresent(d -> {
                    System.out.printf("Highest Average Salary: %s%n", d.getName());
                    d.getDepartmentEmployees().stream()
                            .sorted(Comparator.comparingDouble((Employee::getSalary)).reversed())
                            .forEach(System.out::println);
                });
    }

    private static Employee buildEmployee(String[] employeeData) {
        Employee employee = new Employee()
                .withName(employeeData[0])
                .withSalary(Double.parseDouble(employeeData[1]))
                .atPosition(employeeData[2])
                .inDepartment(employeeData[3]);

        if (employeeData.length == 5)
            if (employeeData[4].contains("@")) {
                employee.setEmail(employeeData[4]);
            } else {
                employee.setAge(Integer.parseInt(employeeData[4]));
            }

        else if (employeeData.length == 6) {
            employee.setEmail(employeeData[4]);
            employee.setAge(Integer.parseInt(employeeData[5]));
        }
        return employee;
    }

    private static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email = "n/a";
        private int age = -1;

        public Employee() {
        }

        public Employee withName(String name) {
            this.name = name;
            return this;
        }

        public Employee withSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Employee atPosition(String position) {
            this.position = position;
            return this;
        }

        public Employee inDepartment(String department) {
            this.department = department;
            return this;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s %.2f %s %d",
                    name, salary, email, age
            );
        }
    }

    private static class Department {
        private final String name;
        private final List<Employee> departmentEmployees = new ArrayList<>();
        private double payroll;

        public Department(String name) {
            this.name = name;
        }

        public void add(Employee employee) {
            departmentEmployees.add(employee);
            payroll += employee.getSalary();
        }

        public String getName() {
            return name;
        }

        public List<Employee> getDepartmentEmployees() {
            return departmentEmployees;
        }

        public double getAvgSalary() {
            return payroll / departmentEmployees.size();
        }
    }
}
