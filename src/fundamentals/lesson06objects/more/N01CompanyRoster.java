package lesson06objects.more;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N01CompanyRoster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeesCount = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>(employeesCount);
        processInputData(scanner, employeesCount, departments);

        Department highestAvgSalaryDep = getHighestAvgSalaryDepartment(departments);
        List<Employee> employees = getEmployeeListSortedBySalaryDesc(highestAvgSalaryDep);

        printResults(highestAvgSalaryDep, employees);
    }

    private static void processInputData(Scanner scanner, int employeesCount, List<Department> departments) {
        for (int i = 0; i < employeesCount; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            Employee employee = buildEmployee(employeeData);
            Department department = findExistingDepartment(departments, employee.getDepartment());
            if (department == null) department = createDepartment(departments, employee.getDepartment());
            department.add(employee);
        }
    }

    private static Department getHighestAvgSalaryDepartment(List<Department> departments) {
        Department highestAvgSalaryDep;
        highestAvgSalaryDep = departments.stream()
                .max(Comparator.comparingDouble(Department::getAvgSalary))
                .orElse(null);
        return highestAvgSalaryDep;
    }

    private static List<Employee> getEmployeeListSortedBySalaryDesc(Department highestAvgSalaryDep) {
        return new ArrayList<>(highestAvgSalaryDep.getDepartmentEmployees()).stream()
                .sorted(Comparator.comparingDouble((Employee::getSalary)).reversed())
                .collect(Collectors.toList());
    }

    private static void printResults(Department highestAvgSalaryDep, List<Employee> employees) {
        System.out.printf("Highest Average Salary: %s%n", highestAvgSalaryDep.getName());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
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

    private static Department findExistingDepartment(List<Department> departments, String departmentName) {
        return departments.stream()
                .filter(e -> e.getName().equals(departmentName))
                .findAny()
                .orElse(null);
    }

    private static Department createDepartment(List<Department> departments, String departmentName) {
        Department department = new Department(departmentName);
        departments.add(department);
        return department;
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

        public void add(Employee departmentEmployee) {
            departmentEmployees.add(departmentEmployee);
            payroll += departmentEmployee.getSalary();
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
