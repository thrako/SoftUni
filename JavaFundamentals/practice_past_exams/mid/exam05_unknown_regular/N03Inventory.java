package practice_past_exams.mid.exam05_unknown_regular;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N03Inventory {
    private static final String END = "Craft!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        int idx;
        String input = scanner.nextLine(), command, item, oldItem, newItem;
        String[] tokens, itemsToCombine;
        while (!END.equals(input)) {
            tokens = input.split(" - ");
            command = tokens[0];
            switch (command) {
                case "Collect":
                    item = tokens[1];
                    if (!inventory.contains(item)) inventory.add(item);
                    break;
                case "Drop":
                    item = tokens[1];
                    inventory.remove(item);
                    break;
                case "Combine Items":
                    itemsToCombine = tokens[1].split(":");
                    oldItem = itemsToCombine[0];
                    newItem = itemsToCombine[1];
                    idx = inventory.indexOf(oldItem);
                    if (idx != -1) inventory.add(idx + 1, newItem);
                    break;
                case "Renew":
                    item = tokens[1];
                    if (inventory.contains(item)) {
                        inventory.remove(item);
                        inventory.add(item);
                    }
                default:
            }
            input = scanner.nextLine();
        }
        printDelimited(inventory, ", ");
    }

    private static void printDelimited(List<String> list, String delimiter) {
        StringBuilder strBld = new StringBuilder();
        int length = list.size();
        for (int i = 0; i < length - 1; i++) {
            strBld.append(list.get(i)).append(delimiter);
        }
        strBld.append(list.get(length - 1));
        System.out.println(strBld);
    }
}
