package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Corps;
import lesson04_interfaces.exercise.n06_military.enums.Formats;
import lesson04_interfaces.exercise.n06_military.interfaces.Commando;

import java.util.ArrayList;
import java.util.Collection;

public class CommandoImpl extends SpecializedSoldierImpl implements Commando {

    private Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder missionsBld = new StringBuilder()
                .append(super.toString())
                .append(Formats.NEW_LINE).append("Missions:");

        missions.forEach(mission -> missionsBld
                .append(mission.toString()));

        return missionsBld.toString();
    }
}
