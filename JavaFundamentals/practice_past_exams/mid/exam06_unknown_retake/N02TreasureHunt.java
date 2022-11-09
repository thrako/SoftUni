package practice_past_exams.mid.exam06_unknown_retake;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Chest chest = new Chest(scanner).initialize().processUntil("Yohoho!");
        if (chest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", chest.evaluate());
        }
    }

    private static class Chest {
        private final Scanner scanner;
        private final StringBuilder strBld = new StringBuilder();
        private List<String> items;

        public Chest(Scanner scanner) {
            this.scanner = scanner;
        }

        public Chest initialize() {
            this.items = Arrays.stream(scanner.nextLine().split("\\|"))
                    .collect(Collectors.toList());
            return this;
        }

        public Chest processUntil(String endCommand) {
            String input = scanner.nextLine();
            if (endCommand.equals(input)) {
                return this;
            }
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    List<String> itemsToAdd = Arrays.stream(Arrays.copyOfRange(tokens, 1, tokens.length))
                            .filter(e -> !this.items.contains(e))
                            .collect(Collectors.toList());
                    Collections.reverse(itemsToAdd);
                    this.items.addAll(0, itemsToAdd);
                    break;
                case "Drop":
                    int idx = Integer.parseInt(tokens[1]);
                    if (idx >= 0 && idx < this.items.size()) {
                        String item = this.items.get(idx);
                        this.items.remove(idx);
                        this.items.add(item);
                    }
                    break;
                case "Steal":
                    int count = Math.min(Integer.parseInt(tokens[1]), this.items.size());
                    List<String> sublist = this.items.subList(this.items.size() - count, this.items.size());
                    printDelimited( sublist, ", ");
                    sublist.clear();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            return processUntil(endCommand);
        }

        private void printDelimited(List<String> list, String delimiter) {
            int length = list.size();
            for (int i = 0; i < length - 1; i++) {
                strBld.append(list.get(i)).append(delimiter);
            }
            strBld.append(list.get(length - 1));
            System.out.println(strBld);
            strBld.setLength(0);
        }

        public double evaluate() {
            int count = items.size();
            if (count == 0) return 0;
            int sum = items.stream()
                    .map(String::length)
                    .reduce(Integer::sum)
                    .orElse(0);
            return (double) sum / count;
        }

        public boolean isEmpty() {
            return this.items.size() == 0;
        }
    }
}
