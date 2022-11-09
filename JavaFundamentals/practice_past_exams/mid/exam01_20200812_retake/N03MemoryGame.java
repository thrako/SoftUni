package practice_past_exams.mid.exam01_20200812_retake;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> memos = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int counter = 0;
        while (!"end".equals(input)) {
            int[] guesses = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            counter++;

            if (areValid(guesses, memos)) {
                String first = memos.get(guesses[0]);
                String second = memos.get(guesses[1]);
                if (first.equals(second)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", first);
                    memos.remove(Math.max(guesses[0], guesses[1]));
                    memos.remove(Math.min(guesses[0], guesses[1]));
                } else {
                    System.out.println("Try again!");
                }
            } else {
                System.out.println("Invalid input! Adding additional elements to the board");
                int middle = memos.size() / 2;
                List<String> elementsToAdd = Arrays.asList(new String[2]);
                Collections.fill(elementsToAdd, String.format("-%da", counter));
                memos.addAll(middle, elementsToAdd);
            }
            if (memos.size() == 0) {
                System.out.printf("You have won in %d turns!", counter);
                break;
            }
            input = scanner.nextLine();
        }
        if (memos.size() > 0) {
            System.out.println("Sorry you lose :(");
            StringBuilder strBld = new StringBuilder();
            for (String memo : memos) {
                strBld.append(memo).append(" ");
            }
            System.out.println(strBld.toString().trim());
        }
    }

    private static boolean areValid(int[] guesses, List<String> memos) {
        return (guesses[0] != guesses[1]
                && isInBounds(memos.size(), guesses[0])
                && isInBounds(memos.size(), guesses[1]));
    }

    private static boolean isInBounds(int size, int idx) {
        return idx >= 0 && idx < size;
    }
}
