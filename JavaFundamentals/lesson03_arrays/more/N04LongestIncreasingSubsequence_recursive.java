package lesson03_arrays.more;

import java.util.Arrays;
import java.util.Scanner;

public class N04LongestIncreasingSubsequence_recursive {
    public static String longestSubSeq = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arrLength = sequence.length;

        StringBuilder currentSubSeq = new StringBuilder();
        for (int i = 0; i < arrLength; i++) {
            currentSubSeq.setLength(0);
            currentSubSeq.append(sequence[i]).append(" ");
            findLIS(currentSubSeq, sequence, i, i + 1);
        }


        // print LIS
        System.out.println(longestSubSeq);
    }

    private static void findLIS(StringBuilder currSS, int[] sequence, int index, int next) {

        if (next == sequence.length) return;

        if (sequence[index] < sequence[next]) {
            currSS.append(sequence[next]).append(" ");
            if (longestSubSeq.length() < currSS.length()) {
                System.out.println(currSS);
                longestSubSeq = currSS.toString();
            }
            index = next;
        }
        next++;
        for (int i = next; i < sequence.length; i++) {

            findLIS(currSS, sequence, i, i+1);
            currSS.setLength(0);
        }
    }
}
