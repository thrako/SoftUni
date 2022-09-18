package lesson06_defining_classes.exercise.N07Google;

import java.util.ArrayList;
import java.util.List;

class Person {
    private final String name;
    private final List<Pokemon> pokemons = new ArrayList<>();
    private final List<Parent> parents = new ArrayList<>();
    private final List<Child> children = new ArrayList<>();
    private Company company = null;
    private Car car = null;

    public Person(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        strBld.append(this.name).append(System.lineSeparator());

        strBld.append("Company:").append(System.lineSeparator());
        if (this.company != null) strBld.append(this.company).append(System.lineSeparator());

        strBld.append("Car:").append(System.lineSeparator());
        if (this.car != null) strBld.append(this.car).append(System.lineSeparator());

        strBld.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            strBld.append(pokemon.toString()).append(System.lineSeparator());
        }

        strBld.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parents) {
            strBld.append(parent.toString()).append(System.lineSeparator());
        }

        strBld.append("Children:").append(System.lineSeparator());
        for (Child child : children) {
            strBld.append(child.toString()).append(System.lineSeparator());
        }

        return strBld.toString();
    }
}
