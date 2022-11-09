package lesson05_lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N05BombNumbers {
    private static List<Integer> intList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        intList = getIntList(scanner);
        String[] bombPower = scanner.nextLine().split("\\s+");
        int bomb = Integer.parseInt(bombPower[0]);
        int power = Integer.parseInt(bombPower[1]);

        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) == bomb) {
                detonate(i, power);
                i = 0;
            }
        }
        System.out.println(sum(intList));
    }

    private static long sum(List<Integer> intList) {
        long sum = 0;
        for (Integer number : intList) {
            sum += number;
        }
        return sum;
    }

    private static List<Integer> getIntList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void detonate(int bomb, int power) {
        for (int i = bomb + power; i >= bomb - power ; i--) {
            if (isInBounds(i)) {
                intList.remove(i);
            }
        }
    }

    private static boolean isInBounds(int idx) {
        return idx >= 0 && idx < intList.size();
    }
}
