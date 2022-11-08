package lesson05_functional_programming.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N08CustomComparator {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (x, y) -> {
            if (x % 2 == 0 && y % 2 != 0) return -1;
            if (x % 2 != 0 && y % 2 == 0) return 1;
            else return x.compareTo(y);
        };

        Scanner scanner = new Scanner(System.in);
        Integer[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(arr, comparator);
        System.out.println(Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
