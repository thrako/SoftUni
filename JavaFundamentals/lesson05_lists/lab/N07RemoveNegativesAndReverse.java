package lesson05_lists.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .filter(integer -> integer >= 0)
                .collect(Collectors.toList());
        Collections.reverse(numbers);
        if (numbers.size() > 0) {
            printDelimited(numbers, " ");
        } else {
            System.out.println("empty");
        }
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
