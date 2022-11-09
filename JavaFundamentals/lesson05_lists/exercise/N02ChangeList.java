package lesson05_lists.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> intList = getIntList(scanner);

        String[] tokens = scanner.nextLine().split(" ");
        while (!"end".equals(tokens[0])) {
            if ("Delete".equals(tokens[0])) {
                intList.removeAll(Collections.singleton(Integer.parseInt(tokens[1])));
            } else if ("Insert".equals(tokens[0])) {
                intList.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
            }
            tokens = scanner.nextLine().split(" ");
        }


        printDelimited(intList, " ");

    }

    private static List<Integer> getIntList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
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
