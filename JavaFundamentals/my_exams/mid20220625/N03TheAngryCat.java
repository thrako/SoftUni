package my_exams.mid20220625;

import java.util.Arrays;
import java.util.Scanner;

public class N03TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] items = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int positionIdx = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();

        int leftSum, rightSum;
        switch (type) {
            case "cheap":
                leftSum = Arrays.stream(items, 0, positionIdx)
                        .filter(e -> e < items[positionIdx])
                        .reduce(Integer::sum)
                        .orElse(Integer.MIN_VALUE);

                rightSum = Arrays.stream(items, positionIdx + 1, items.length)
                        .filter(e -> e < items[positionIdx])
                        .reduce(Integer::sum)
                        .orElse(Integer.MIN_VALUE);
                break;
            case "expensive":
                leftSum = Arrays.stream(items, 0, positionIdx)
                        .filter(e -> e >= items[positionIdx])
                        .reduce(Integer::sum)
                        .orElse(Integer.MIN_VALUE);

                rightSum = Arrays.stream(items, positionIdx + 1, items.length)
                        .filter(e -> e >= items[positionIdx])
                        .reduce(Integer::sum)
                        .orElse(Integer.MIN_VALUE);
                break;
            default:
                leftSum = rightSum = Integer.MIN_VALUE;
        }
        if (leftSum >= rightSum) System.out.printf("Left - %d", leftSum);
        if (leftSum < rightSum) System.out.printf("Right - %d", rightSum);
    }
}
