package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Formats;
import lesson04_interfaces.exercise.n06_military.interfaces.Spy;

public class SpyImpl extends SoldierImpl
        implements Spy {

    public String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
               Formats.NEW_LINE + String.format(Formats.CODE_NUMBER, this.getCodeNumber());
    }
}
