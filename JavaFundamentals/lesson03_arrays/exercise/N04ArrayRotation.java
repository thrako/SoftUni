package lesson03_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numRotations = Integer.parseInt(scanner.nextLine());
        int length = arr.length;
        int[] outputArr = new int[length];
        int offset = (length - (numRotations % length)) % length;

        for (int i = 0, j = i + offset; i < length; i++, j++) {
            if (j >= length) j -= length;
            outputArr[j] = arr[i];
        }

        for(int e : outputArr) {
            System.out.print(e + " ");
        }
    }
}
