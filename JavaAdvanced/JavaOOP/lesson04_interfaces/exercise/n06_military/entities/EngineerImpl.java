package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Corps;
import lesson04_interfaces.exercise.n06_military.enums.Formats;
import lesson04_interfaces.exercise.n06_military.interfaces.Engineer;

import java.util.ArrayList;
import java.util.Collection;

public class EngineerImpl extends SpecializedSoldierImpl
        implements Engineer {

    Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder engineerBld = new StringBuilder()
                .append(super.toString())
                .append(Formats.NEW_LINE).append(Formats.REPAIRS);

        this.getRepairs().forEach(repair -> engineerBld
                .append(repair.toString()));

        return engineerBld.toString();
    }
}
