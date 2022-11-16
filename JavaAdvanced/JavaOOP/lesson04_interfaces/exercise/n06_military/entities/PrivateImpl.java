package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Formats;
import lesson04_interfaces.exercise.n06_military.interfaces.Private;

public class PrivateImpl extends SoldierImpl
        implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + Formats.SPACE + String.format(Formats.SALARY, this.getSalary());
    }
}
