package lesson05_lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = getList(scanner);
        List<Integer> secondList = getList(scanner);
        int shorter = Math.min(firstList.size(), secondList.size());
        int longer = Math.max(firstList.size(), secondList.size());
        int length = shorter + longer;
        List<Integer> mergedList = new ArrayList<>(length);
        for (int i = 0; i < shorter; i++) {
            mergedList.add(firstList.get(i));
            mergedList.add(secondList.get(i));
        }
        if (firstList.size() > secondList.size()) {
            for (int i = shorter; i < longer; i++) {
                mergedList.add(firstList.get(i));
            }
        } else if (firstList.size() < secondList.size()) {
            for (int i = shorter; i < longer; i++) {
                mergedList.add(secondList.get(i));
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.printf("%d ", mergedList.get(i));
        }
    }

    private static List<Integer> getList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
