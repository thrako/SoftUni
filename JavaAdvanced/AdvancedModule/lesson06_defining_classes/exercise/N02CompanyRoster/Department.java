package lesson06_defining_classes.exercise.N02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

class Department {
    String name;
    private final List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary() {
        return this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0d);
    }

    public String getName() {
        return name;
    }
}
