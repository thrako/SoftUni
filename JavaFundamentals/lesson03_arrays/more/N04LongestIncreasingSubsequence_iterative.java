package lesson03_arrays.more;

import java.util.Arrays;
import java.util.Scanner;

public class N04LongestIncreasingSubsequence_iterative {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arrLength = sequence.length;
        int[] solutionLengths = new int[arrLength];
        int bestSolutionIndex = arrLength - 1;

        // find the best solution length of each subsequence from right to left
        for (int current = arrLength - 1; current >= 0; current--) {
            solutionLengths[current] = 1;
            for (int prev = arrLength - 1; prev > current; prev--) {
                if (sequence[current] < sequence[prev]) {
                    if (solutionLengths[prev] + 1 > solutionLengths[current]) {
                        solutionLengths[current] = solutionLengths[prev] + 1;
                    }
                    if (solutionLengths[current] >= solutionLengths[bestSolutionIndex]) {
                        bestSolutionIndex = current;
                    }
                }
            }
        }

        // print LIS
        int bestSolutionLength = solutionLengths[bestSolutionIndex];
        for (int i = bestSolutionIndex; i < arrLength; i++) {
            if (solutionLengths[i] == bestSolutionLength) {
                System.out.print(sequence[i] + " ");
                bestSolutionLength--;
            }
        }
    }
}
