package lesson05_functional_programming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class N07FindTheSmallestElement {
    public static void main(String[] args) {
        Function<List<Integer>, Integer> getIndexOfSmallestElement = list -> {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0, listSize = list.size(); i < listSize; i++) {
                if (list.get(i) <= min) {
                    min = list.get(i);
                    index = i;
                }
            }
            return index;
        };

        Scanner scanner = new Scanner(System.in);
        Integer min = getIndexOfSmallestElement.apply(Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        System.out.println(min);
    }
}
