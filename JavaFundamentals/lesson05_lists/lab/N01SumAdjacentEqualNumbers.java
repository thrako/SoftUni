package lesson05_lists.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        reduce(numbers);
        print(numbers);

    }

    private static void reduce(List<Double> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                reduce(numbers);
            }
        }
    }

    private static void print(List<Double> numbers) {
        System.out.println(joinListOfDoublesBy(numbers, " "));
    }

    private static String joinListOfDoublesBy(List<Double> list, String delimiter) {
        StringBuilder sBld = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sBld.append(beautifyDouble(list.get(i))).append(delimiter);
        }
        sBld.append(beautifyDouble((list.get(list.size() - 1))));
        return sBld.toString();
    }

    private static String beautifyDouble(double number) {
        return new DecimalFormat("0.#").format(number);
    }
}
