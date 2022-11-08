package lesson06_defining_classes.exercise.N06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Trainer {
    private final String name;
    private int badges = 0;
    private final List<Pokemon> pokemons = new ArrayList<>();

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void awardBadge() {
        this.badges++;
    }

    public void loseRound() {
        this.pokemons.forEach(Pokemon::reduceHealth);
        this.pokemons.removeAll(this.pokemons.stream()
                .filter(pokemon -> !pokemon.isAlive())
                .collect(Collectors.toList())
        );
    }

    public int getBadges() {
        return this.badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                this.name, this.badges, this.pokemons.size());
    }
}
