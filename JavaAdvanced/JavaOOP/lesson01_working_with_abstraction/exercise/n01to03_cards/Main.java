package lesson01_working_with_abstraction.exercise.n01to03_cards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("Card Suits")) {
            System.out.println("Card Suits:");
            for (Suit suit : Suit.values()) {
                printInfo(suit);
            }
        } else if (input.equals("Card Ranks")) {
            System.out.println("Card Ranks:");
            for (Rank rank : Rank.values()) {
                printInfo(rank);
            }

        } else {
            Rank rank = Rank.valueOf(input);
            Suit suit = Suit.valueOf(scanner.nextLine());
            Card card = new Card(rank, suit);
            System.out.println(card);
        }
    }

    private static <T extends Enum<T>> void  printInfo(Enum<T> val) {
        System.out.printf("Ordinal value: %d; Name value: %s%n", val.ordinal(), val.name());
    }
}
