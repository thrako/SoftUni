package lesson05_lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N06CardsGame {
    private static List<Integer> firstDeck;
    private static List<Integer> secondDeck;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        firstDeck = getIntList(scanner);
        secondDeck = getIntList(scanner);
        while (firstDeck.size() != 0 && secondDeck.size() != 0) {
            playRound();
        }
        if(firstDeck.size() > 0) {
            System.out.printf("First player wins! Sum: %d", sum(firstDeck));
        } else if (secondDeck.size() > 0) {
            System.out.printf("Second player wins! Sum: %d", sum(secondDeck));
        }
    }

    private static List<Integer> getIntList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void playRound() {
        Integer firstCard = firstDeck.get(0);
        Integer secondCard = secondDeck.get(0);
        firstDeck.remove(0);
        secondDeck.remove(0);
        if (firstCard > secondCard) {
            firstDeck.add(firstCard);
            firstDeck.add(secondCard);
        } else if (secondCard > firstCard) {
            secondDeck.add(secondCard);
            secondDeck.add(firstCard);
        }
    }

    private static int sum(List<Integer> intList) {
        int sum = 0;
        for (Integer card : intList) sum += card;
        return sum;
    }
}
