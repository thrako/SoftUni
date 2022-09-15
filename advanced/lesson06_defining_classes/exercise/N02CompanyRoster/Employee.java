package lesson06_defining_classes.exercise.N02CompanyRoster;

@SuppressWarnings({"UnusedReturnValue", "unused"})
class Employee {
    private final String name;
    private final double salary;
    private final String position;
    private final String department;
    private String email = "n/a";
    private int age  = -1;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee addEmail(String email) {
        this.email = email;
        return this;
    }

    public Employee addAge(int age) {
        this.age = age;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }
}
