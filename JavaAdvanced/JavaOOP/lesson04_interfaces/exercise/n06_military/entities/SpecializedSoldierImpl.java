package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Corps;
import lesson04_interfaces.exercise.n06_military.enums.Formats;
import lesson04_interfaces.exercise.n06_military.interfaces.SpecialisedSoldier;

public class SpecializedSoldierImpl extends PrivateImpl
        implements SpecialisedSoldier {

    Corps corps;

    public SpecializedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return super.toString() +
               Formats.NEW_LINE + String.format(Formats.CORPS, this.getCorps());
    }
}
