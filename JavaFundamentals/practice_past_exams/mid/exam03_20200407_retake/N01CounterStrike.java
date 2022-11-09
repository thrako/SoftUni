package practice_past_exams.mid.exam03_20200407_retake;

import java.util.Scanner;

public class N01CounterStrike {
    private static final String END = "End of battle";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int battlesWon = 0;
        int distance;
        String input = scanner.nextLine();

        while (!END.equals(input)) {
            distance = Integer.parseInt(input);
            if (energy >= distance) {
                energy -= distance;
                battlesWon++;
                if (battlesWon % 3 == 0) energy += battlesWon;
            } else {
                System.out.printf(
                        "Not enough energy! Game ends with %d won battles and %d energy",
                        battlesWon, energy
                );
                break;
            }
            input = scanner.nextLine();
        }
        if (END.equals(input)) {
            System.out.printf(
                    "Won battles: %d. Energy left: %d",
                    battlesWon, energy
            );
        }
    }
}
