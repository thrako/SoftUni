package lesson05_lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int pokeIdx, removedElementValue, size, sum = 0;
        while (pokemons.size() > 0) {
            size = pokemons.size();
            pokeIdx = Integer.parseInt(scanner.nextLine());
            if (pokeIdx < 0) {
                removedElementValue = pokemons.get(0);
                sum += removedElementValue;
                pokemons.set(0, pokemons.get(size - 1));
                process(pokemons, removedElementValue);
            } else if (pokeIdx >= size) {
                removedElementValue = pokemons.get(size - 1);
                sum += removedElementValue;
                pokemons.set(size - 1, pokemons.get(0));
                process(pokemons, removedElementValue);
            } else {
                removedElementValue = pokemons.get(pokeIdx);
                sum += removedElementValue;
                process(pokemons, removedElementValue);
                pokemons.remove(pokeIdx);
            }
        }
        System.out.println(sum);
    }

    private static void process(List<Integer> pokemons, int removedElementValue) {
        for (int i = 0, size = pokemons.size(); i < size; i++) {
            int elementValue = pokemons.get(i);
            int setValue = (elementValue <= removedElementValue) ? elementValue + removedElementValue : elementValue - removedElementValue;
            pokemons.set(i, setValue);
        }
    }
}
