package lesson06_defining_classes.exercise.N06PokemonTrainer;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tournament tournament = new Tournament(scanner);
        tournament.registerParticipants();
        tournament.playAllRounds();
        tournament.printResults();
    }
}
