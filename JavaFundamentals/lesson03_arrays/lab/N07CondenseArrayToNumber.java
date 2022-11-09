package lesson03_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = intArrayFromSpaceSeparatedString(scanner.nextLine());
        int[] condensed = condense(numbers);
        System.out.println(condensed[0]);
    }

    private static int[] intArrayFromSpaceSeparatedString(String str) {
        return Arrays
                .stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[] condense(int[] arr) {
        if (arr.length == 1) return arr;
        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i] + arr[i + 1];
        }
        return condense(temp);
    }
}
