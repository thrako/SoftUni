package lesson03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N07_MaxSequenceOfEqualElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] maxSequence = findMaxSequence(arr);
        printArray(maxSequence);
    }

    private static int[] findMaxSequence(int[] arr) {
        int index = 0;
        int maxCount = 1;
        int length = arr.length;

        for (int i = 0; i < length - 1; ) {
            int counter = 1;
            int current = i;
            while ((current < length - 1) && (arr[current] == arr[current + 1])) {
                counter++;
                current++;
            }
            if (counter > maxCount) {
                index = i;
                maxCount = counter;
            }
            i += counter;
        }
        int[] maxSequence = new int[maxCount];

        for (int i = 0; i < maxCount; i++) {
            maxSequence[i] = arr[index + i];
        }

        return maxSequence;
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
