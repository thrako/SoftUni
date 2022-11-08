package lesson05_functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class N03CustomMinFunction {
    public static void main(String[] args) {
        Function<Integer[], Integer> getMin = arr -> {
            int min = Integer.MAX_VALUE;
            for (Integer number : arr) {
                if (number < min) min = number;
            }
            return min;
        };

        Scanner scanner = new Scanner(System.in);
        int min = getMin.apply(Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new));

        System.out.println(min);
    }
}
