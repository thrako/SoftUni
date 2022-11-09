package practice_past_exams.mid.exam04_20200229_regular;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N02ShoppingList {
    private static final String END = "Go Shopping!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command, item, newItem = null;
        String input = scanner.nextLine();
        String[] tokens;
        int idx;
        while (!END.equals(input)) {
            tokens = input.split("\\s+");
            command = tokens[0];
            item = tokens[1];
            if (tokens.length > 2) {
                newItem = tokens[2];
            }

            switch (command) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.remove(item);
                    break;
                case "Correct":
                    idx = shoppingList.indexOf(item);
                    if (idx != -1) {
                        shoppingList.set(idx, newItem);
                    }
                    break;
                case "Rearrange":
                    idx = shoppingList.indexOf(item);
                    if (idx != -1) {
                        shoppingList.remove(idx);
                        shoppingList.add(item);
                    }
                    break;
                default:
            }
            input = scanner.nextLine();
        }
        printDelimited(shoppingList, ", ");
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
