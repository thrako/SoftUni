package lesson04_interfaces.exercise.n06_military.interfaces;

import lesson04_interfaces.exercise.n06_military.entities.Mission;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier {

    void addMission(Mission mission);

    Collection<Mission> getMissions();

}
