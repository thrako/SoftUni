package lesson06_defining_classes.exercise.N06PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Tournament {
    private final Map<String, Trainer> participants = new LinkedHashMap<>();
    private final Scanner scanner;

    public Tournament(Scanner scanner) {
        this.scanner = scanner;
    }

    public void registerParticipants() {
        String input = this.scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] inputData = input.split("\\s+");
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);
            this.participants.putIfAbsent(trainerName, new Trainer(trainerName));
            this.participants.get(trainerName).addPokemon(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            input = this.scanner.nextLine();
        }        
    }

    public void playAllRounds() {
        String input = this.scanner.nextLine();
        while (!"End".equals(input)) {
            playRound(input);
            input = this.scanner.nextLine();
        }
    }

    private void playRound(String element) {
        this.participants.values().stream().forEach(t -> {
            if ((t.getPokemons().stream().anyMatch(p -> p.getElement().equals(element)))) {
                t.awardBadge();
            } else {
                t.loseRound();
            }
        });
    }

    public void printResults() {
        this.participants.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getBadges(), p1.getBadges()))
                .forEach(System.out::println);
    }
}
