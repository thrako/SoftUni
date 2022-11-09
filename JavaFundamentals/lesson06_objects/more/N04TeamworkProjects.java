package lesson06_objects.more;

import java.util.*;
import java.util.stream.Collectors;

public class N04TeamworkProjects {
    private static final String END = "end of assignment";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Team> teams = registerTeams(scanner);
        registerMembers(teams, scanner);
        printSorted(teams);
    }

    private static List<Team> registerTeams(Scanner scanner) {
        int teamsCount = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>(teamsCount);
        String[] tokens;
        String input;
        for (int i = 0; i < teamsCount; i++) {
            input = scanner.nextLine();
            tokens = input.split("-");
            String teamName = tokens[1];
            String founder = tokens[0];
            if (isRegistered(teamName, teams)) System.out.printf("Team %s was already created!%n", teamName);
            else if (isFounder(founder, teams)) System.out.printf("%s cannot create another team!%n", founder);
            else {
                teams.add(new Team(teamName, founder));
                System.out.printf("Team %s has been created by %s!%n", teamName, founder);
            }
        }
        return teams;
    }

    private static void registerMembers(List<Team> teams, Scanner scanner) {
        String input;
        String[] tokens;
        input = scanner.nextLine();
        while (!END.equals(input)) {
            tokens = input.split("->");
            String newMember = tokens[0];
            String teamName = tokens[1];
            if (!isRegistered(teamName, teams)) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else if (isFounder(newMember, teams) || isMember(newMember, teams)) {
                System.out.printf("Member %s cannot join team %s!%n", newMember, teamName);
            } else {
                teams.stream()
                        .filter(t -> t.getName().equals(teamName))
                        .findAny()
                        .ifPresent(t -> t.addMember(newMember));
            }
            input = scanner.nextLine();
        }
    }

    private static void printSorted(List<Team> teams) {
        List<Team> sortedTeams = teams.stream()
                .sorted(Comparator.comparingInt(Team::getMembersCount)
                        .reversed()
                        .thenComparing(Team::getName))
                .collect(Collectors.toList());

        sortedTeams.stream()
                .filter(t -> t.getMembersCount() > 0)
                .forEach(System.out::print);

        System.out.println("Teams to disband:");
        sortedTeams.stream()
                .filter(t -> t.getMembersCount() == 0)
                .forEach(t -> System.out.println(t.getName()));
    }

    private static boolean isRegistered(String teamName, List<Team> teams) {
        return teams.stream().anyMatch(t -> t.getName().equals(teamName));
    }

    private static boolean isFounder(String user, List<Team> teams) {
        return teams
                .stream()
                .map(Team::getFounder)
                .anyMatch(founderName -> founderName.equals(user));

    }

    private static boolean isMember(String newMember, List<Team> teams) {
        return teams.stream()
                .map(Team::getMembers)
                .anyMatch(ls -> ls.contains(newMember));
    }

    private static class Team {
        private final String name;
        private final String founder;
        private final List<String> members = new ArrayList<>();

        public Team(String name, String founder) {
            this.name = name;
            this.founder = founder;
        }

        public String getName() {
            return name;
        }

        public String getFounder() {
            return founder;
        }

        public List<String> getMembers() {
            return members;
        }

        public void addMember(String newMember) {
            this.members.add(newMember);
        }

        public int getMembersCount() {
            return members.size();
        }

        @Override
        public String toString() {
            StringBuilder strBld = new StringBuilder(
                    String.format(
                            "%s%n" +
                            "- %s%n",
                            name, founder
                    ));
            List<String> sortedMembers = new ArrayList<>(members);
            Collections.sort(sortedMembers);
            for (String member : sortedMembers) {
                strBld.append(
                        String.format(
                                "-- %s%n",
                                member
                        ));
            }
            return strBld.toString();
        }
    }
}
