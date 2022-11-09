package lesson05_lists.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> intList = getIntList(scanner);

        String[] tokens = scanner.nextLine().split("\\s+");
        int idx, number, count;
        String command, direction;
        while (!"End".equals(tokens[0])) {
            command = tokens[0];
            switch (command) {
                case "Add":
                    number = Integer.parseInt(tokens[1]);
                    intList.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    idx = Integer.parseInt(tokens[2]);
                    if (isInBounds(idx, intList)) intList.add(idx, number);
                    else System.out.println("Invalid index");
                    break;
                case "Remove":
                    idx = Integer.parseInt(tokens[1]);
                    if (isInBounds(idx, intList)) intList.remove(idx);
                    else System.out.println("Invalid index");
                    break;
                case "Shift":
                    direction = tokens[1];
                    count = Integer.parseInt(tokens[2]);
                    if ("left".equals(direction)) shiftLeft(intList, count);
                    if ("right".equals(direction)) shiftRight(intList, count);
                    break;
            }

            tokens = scanner.nextLine().split("\\s+");
        }


        printDelimited(intList, " ");

    }

    private static boolean isInBounds(int idx, List<Integer> intList) {
        return idx >= 0 && idx < intList.size();
    }

    private static void shiftLeft(List<Integer> intList, int count) {
        int offset = count % intList.size();
        Collections.rotate(intList, intList.size() - offset);
    }

    private static void shiftRight(List<Integer> intList, int count) {
        int offset = count % intList.size();
        Collections.rotate(intList, offset);
    }

    private static List<Integer> getIntList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void printDelimited(List<Integer> numbers, String delimiter) {
        StringBuilder strBld = new StringBuilder();
        for (int i = 0, length = numbers.size(); i < length; i++) {
            strBld.append(numbers.get(i));
            if (i != length - 1) {
                strBld.append(delimiter);
            }
        }
        System.out.println(strBld);
    }
}
