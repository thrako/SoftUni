package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Formats;
import lesson04_interfaces.exercise.n06_military.interfaces.LieutenantGeneral;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl
        implements LieutenantGeneral {

    private List<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public List<PrivateImpl> getPrivates() {
        return privates;
    }

    @Override
    public void addPrivate(PrivateImpl priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        final StringBuilder genLieutenantBld = new StringBuilder(super.toString())
                .append(Formats.NEW_LINE).append(Formats.PRIVATES);

        this.getPrivates().stream()
                .sorted(LieutenantGeneralImpl::privateCompareByIdDesc)
                .forEach(priv -> genLieutenantBld.append(Formats.NEW_LINE)
                        .append(Formats.DOUBLE_SPACE).append(String.format(Formats.PRIVATE,
                                priv.getFirstName(), priv.getLastName(), priv.getId(), priv.getSalary())));

        return genLieutenantBld.toString();
    }

    private static int privateCompareByIdDesc(PrivateImpl p1, PrivateImpl p2) {
        return Integer.compare(p2.getId(), p1.getId());
    }
}
