package lesson02_encapsulation.lab.n04_first_and_reserve_team;

import java.text.DecimalFormat;

public class Person {
    private static final String DESCRIPTION_FORMAT = "%s %s gets %s leva";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        PersonValidator.validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        PersonValidator.validateLastName(lastName);
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        PersonValidator.validateAge(age);
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        PersonValidator.validateSalary(salary);
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
