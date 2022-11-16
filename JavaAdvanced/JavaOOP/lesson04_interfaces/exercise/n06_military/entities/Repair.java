package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Formats;

public class Repair {

    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    public String getPartName() {
        return partName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {

        return Formats.NEW_LINE + Formats.DOUBLE_SPACE + String.format(Formats.REPAIR,
                this.getPartName(), this.getHoursWorked());
    }
}
