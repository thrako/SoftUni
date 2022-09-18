package lesson06_defining_classes.exercise.N07Google;

class Company {
    private final String name;
    private final String department;
    private final double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.name, this.department, this.salary);
    }
}
