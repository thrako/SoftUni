package lesson02_encapsulation.exercise.n05_footbal_team_generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player playerToRemove = players.stream()
                .filter(p -> p.getName().equals(playerName))
                .findFirst()
                .orElse(null);
        if (playerToRemove == null) {
            String message = String.format("Player %s is not in %s team.", playerName, this.getName());
            throw new IllegalArgumentException(message);
        }
        this.players.remove(playerToRemove);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
        return Math.round(players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average().orElse(0.0)
        );
    }
}
