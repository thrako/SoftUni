package lesson02_encapsulation.lab.n04_first_and_reserve_team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private static final String TEAM_FORMAT = "%s team have %d players";

    private final String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }

    public String getFirstTeamInfo() {
        return String.format(TEAM_FORMAT, "First", firstTeam.size());
    }

    public String getReserveTeamInfo() {
        return String.format(TEAM_FORMAT, "Reserve", reserveTeam.size());
    }
}
