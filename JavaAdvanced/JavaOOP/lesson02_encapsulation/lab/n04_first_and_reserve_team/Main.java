package lesson02_encapsulation.lab.n04_first_and_reserve_team;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Team team = addPlayersFromConsole(
                new Scanner(System.in),
                new Team("Java Ninjas")
        );

        printTeamInfo(team);
    }

    private static Team addPlayersFromConsole(Scanner scanner, Team team) {
        int playersCount = Integer.parseInt(scanner.nextLine());

        while (playersCount-- > 0) {
            final String[] personData = scanner.nextLine().split(" ");
            try {
                team.addPlayer(getPerson(personData));
            } catch (IllegalPersonArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return team;
    }

    private static Person getPerson(String[] personData) throws IllegalPersonArgumentException {
        final var firstName = personData[0];
        final var lastName = personData[1];
        final var age = Integer.parseInt(personData[2]);
        final var bonus = Double.parseDouble(personData[3]);

        return new Person(firstName, lastName, age, bonus);
    }

    private static void printTeamInfo(Team team) {
        System.out.println(team.getFirstTeamInfo());
        System.out.println(team.getReserveTeamInfo());
    }

}
