package lesson02_encapsulation.exercise.n05_footbal_team_generator;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TeamRepository {
    private final Map<String, Team> teams = new LinkedHashMap<>();

    public void add(Team team) {
        teams.put(team.getName(), team);
    }

    public Team getTeam(String teamName) {
        if (!teams.containsKey(teamName)) {
            String message = String.format("Team %s does not exist.", teamName);
            throw new IllegalArgumentException(message);
        }
        return teams.get(teamName);
    }

    public Map<String, Team> getTeams() {
        return Collections.unmodifiableMap(teams);
    }
}
