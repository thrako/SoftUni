package lesson02_encapsulation.lab.n02_salary_increase;

import java.text.DecimalFormat;

public class Person {

    private static final String DESCRIPTION_FORMAT = "%s %s gets %s leva";
    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double increasePct = bonus / 100;
        if (this.age < 30) {
            increasePct /= 2;
        }
        this.salary *= (1 + increasePct);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.0##");
        return String.format(DESCRIPTION_FORMAT,
                firstName, lastName, decimalFormat.format(salary));
    }
}
