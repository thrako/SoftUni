package lesson03_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] temp = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (i % 2 == 0) {
                arr1[i] = temp[0];
                arr2[i] = temp[1];
            } else {
                arr1[i] = temp[1];
                arr2[i] = temp[0];
            }
        }

        for(int e : arr1) {
            System.out.print(e + " ");
        }
        System.out.println();
        for(int e : arr2) {
            System.out.print(e + " ");
        }
    }
}
