package lesson05_lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0, length = numbers.size(); i < length / 2; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(length - 1 - i));
            numbers.remove((length - 1 - i));
        }
        printJoined(numbers, " ");
    }

    private static void printJoined(List<Integer> list, String delimiter) {
        StringBuilder sBld = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sBld.append(list.get(i)).append(delimiter);
        }
        sBld.append((list.get(list.size() - 1)));
        System.out.println(sBld);
    }
}

