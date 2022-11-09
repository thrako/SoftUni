package lesson05_lists.more;

import java.util.*;
import java.util.stream.Collectors;

public class N04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int firstSize = firstList.size();

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int secondSize = secondList.size();

        int min = (firstSize > secondSize)
                ? Math.min(firstList.get(firstSize - 1), firstList.get(firstSize - 2))
                : Math.min(secondList.get(0), secondList.get(1));
        int max = (firstSize > secondSize)
                ? Math.max(firstList.get(firstSize - 1), firstList.get(firstSize - 2))
                : Math.max(secondList.get(0), secondList.get(1));

        firstList.removeIf(e -> e <= min || e >= max);
        secondList.removeIf(e -> e <= min || e >= max);

        List<Integer> result = new ArrayList<>();
        result.addAll(firstList);
        result.addAll(secondList);
        Collections.sort(result);

        printDelimited(result);
    }

    private static void printDelimited(List<Integer> result) {
        int size = result.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.print(result.get(size - 1));
    }
}
