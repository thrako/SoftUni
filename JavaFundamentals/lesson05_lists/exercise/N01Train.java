package lesson05_lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = getIntList(scanner);
        int capacity = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split(" ");
        while (!"end".equals(tokens[0])) {
            if ("Add".equals(tokens[0])) {
                wagons.add(Integer.parseInt(tokens[1]));
            } else {
                Integer passengers = Integer.parseInt(tokens[0]);
                for (int i = 0, length = wagons.size(); i < length; i++) {
                    if ((wagons.get(i) + passengers) <= capacity) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
            tokens = scanner.nextLine().split(" ");
        }
        printDelimited(wagons, " ");

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
