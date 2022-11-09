package lesson03_arrays.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class N08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int magicSum = Integer.parseInt(scanner.nextLine());

        Set<String> uniquePairs = new HashSet<String>();

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {

            for (int j = i + 1; j < length; j++) {
                if (arr[i] + arr[j] == magicSum) {
                    String pair = String.format("%d %d", arr[i], arr[j]);
                    if (!uniquePairs.contains(pair)) System.out.println(pair);
                    uniquePairs.add(pair);
                }
            }
        }
    }
}
