package practice_past_exams.mid.exam03_20200407_retake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Shoot":
                    shoot(targets, tokens[1], tokens[2]);
                    break;
                case "Add":
                    add(targets, tokens[1], tokens[2]);
                    break;
                case "Strike":
                    strike(targets, tokens[1], tokens[2]);
                    break;
                default:
            }
            input = scanner.nextLine();
        }
        if (targets.size() > 0) {
            printDelimited(targets, "|");
        }
    }

    private static void shoot(List<Integer> targets, String token1, String token2) {
        int idx = Integer.parseInt(token1);
        int power = Integer.parseInt(token2);
        if (isValid(idx, targets.size())) {
            int targetValue = targets.get(idx) - power;
            if (targetValue > 0) {
                targets.set(idx, targetValue);
            } else {
                targets.remove(idx);
            }
        }
    }

    private static void add(List<Integer> targets, String token1, String token2) {
        int idx = Integer.parseInt(token1);
        Integer value = Integer.parseInt(token2);
        if (isValid(idx, targets.size())) {
            targets.add(idx, value);
        } else {
            System.out.println("Invalid placement!");
        }
    }

    private static void strike(List<Integer> targets, String token1, String token2) {
        int idx = Integer.parseInt(token1);
        int radius = Integer.parseInt(token2);
        int start = idx - radius;
        int end = idx + radius;
        if (isValid(start, targets.size()) && isValid(end, targets.size())) {
            targets.subList(start, end + 1).clear();
        } else {
            System.out.println("Strike missed!");
        }
    }

    private static void printDelimited(List<Integer> targets, String delimiter) {
        StringBuilder strBld = new StringBuilder();
        int length = targets.size();
        for (int i = 0; i < length - 1; i++) {
            strBld.append(targets.get(i)).append(delimiter);
        }
        strBld.append(targets.get(length - 1));
        System.out.println(strBld);
    }

    private static boolean isValid(int idx, int size) {
        return idx >= 0 && idx < size;
    }
}
