package lesson03_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index = findEqual(arr);
        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }

    private static int findEqual(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int leftSum = (i == 0) ? 0 : sum(arr, 0, i-1);
            int rightSum = (i == length - 1) ? 0 : sum(arr, i + 1, length - 1);
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    private static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
