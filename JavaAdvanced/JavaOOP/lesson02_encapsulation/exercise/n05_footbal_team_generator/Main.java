package lesson02_encapsulation.exercise.n05_footbal_team_generator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TeamRepository teamRepo = new TeamRepository();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            switch (command) {
                case "Team":
                    try {
                        String teamName = tokens[1];
                        Team team = new Team(teamName);
                        teamRepo.add(team);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    try {
                        String teamName = tokens[1];
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        Team team = teamRepo.getTeam(teamName);
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        team.addPlayer(player);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Remove":
                    try {
                        String teamName = tokens[1];
                        String playerName = tokens[2];
                        Team team = teamRepo.getTeam(teamName);
                        team.removePlayer(playerName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    try {
                        String teamName = tokens[1];
                        Team team = teamRepo.getTeam(teamName);
                        System.out.printf("%s - %.0f%n", teamName, team.getRating());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            input = scanner.nextLine();
        }
    }
}
