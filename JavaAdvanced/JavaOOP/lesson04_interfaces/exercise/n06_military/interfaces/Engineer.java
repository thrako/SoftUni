package lesson04_interfaces.exercise.n06_military.interfaces;

import lesson04_interfaces.exercise.n06_military.entities.Repair;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {

    void addRepair(Repair repair);

    Collection<Repair> getRepairs();
}
