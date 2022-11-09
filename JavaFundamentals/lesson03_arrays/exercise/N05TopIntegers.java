package lesson03_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean isTop = true;
            for (int j = i + 1; j < length; j++) {
                if (arr[i] <= arr[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) System.out.print(arr[i] + " ");
        }
    }
}
