package lesson03_arrays.lab;

import java.util.Scanner;

public class N04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }

    private static void swap(String[] arr, int left, int right) {
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
