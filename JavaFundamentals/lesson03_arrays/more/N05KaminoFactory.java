package lesson03_arrays.more;

import java.util.Arrays;
import java.util.Scanner;

public class N05KaminoFactory {
    private static final String END = "Clone them!";
    private static int dnaLength;
    private static final int[] ALLOWED_SYMBOLS = new int[]{0, 1};
    private static int[] bestSequence;
    private static int bestLength = 0;
    private static int bestSum = 0;
    private static int bestIndex = Integer.MAX_VALUE;
    private static int bestSeqSerialNum = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dnaLength = Integer.parseInt(scanner.nextLine());
        bestSequence = new int[dnaLength];

        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals(END)) {
            int[] currSequence = intArrFrom(input);
            counter++;

            if (!isValid(currSequence)) {
                input = scanner.nextLine();
                continue;
            }

            int[] currResults = calcResults(currSequence);
            if (areBetter(currResults)) {
                setBest(currSequence, currResults, counter);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSeqSerialNum, bestSum);
        printSequence(bestSequence, " ");
    }

    private static int[] intArrFrom(String input) {
        return Arrays.stream(input.split("!+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isValid(int[] currSequence) {
        if (currSequence.length != dnaLength) {
            return false;
        } else {
            for (int currNum : currSequence) {
                boolean valid = Arrays.stream(ALLOWED_SYMBOLS).anyMatch(e -> e == currNum);
                if (!valid) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] calcResults(int[] seqNums) {
        int arrL = seqNums.length;
        int[] seqLens = new int[arrL];
        int locBestLen = 0;
        int locBestIndex = -1;

        for (int i = 0; i < arrL; i++) {
            seqLens[i] = 0;
            if (seqNums[i] == 1) {
                seqLens[i] = 1;
                for (int j = i + 1; j < arrL; j++) {
                    if (seqNums[j] == 1) {
                        seqLens[i]++;
                    } else {
                        break;
                    }
                }
            }
            if (seqLens[i] > locBestLen) {
                locBestLen = seqLens[i];
                locBestIndex = i;
            }
        }
        int locSum = Arrays.stream(seqNums).sum();

        return new int[]{locBestLen, locBestIndex, locSum};
    }

    private static boolean areBetter(int[] results) {
        int currLength = results[0];
        int currIndex = results[1];
        int currSum = results[2];

        if (currLength > bestLength) {
            return true;

        } else if (currLength == bestLength) {
            if (currIndex < bestIndex) {
                return true;

            } else if (currIndex == bestIndex) {
                return currSum > bestSum;
            }
        }

        return false;
    }

    private static void setBest(int[] currSequence, int[] results, int serialNum) {
        int currLength = results[0];
        int currIndex = results[1];
        int currSum = results[2];

        bestSequence = currSequence;
        bestLength = currLength;
        bestIndex = currIndex;
        bestSum = currSum;
        bestSeqSerialNum = serialNum;
    }

    private static void printSequence(int[] bestSequence, String delimiter) {
        int i, arrLen = bestSequence.length;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < arrLen - 1; i++) {
            sb.append(bestSequence[i]).append(delimiter);
        }
        sb.append(bestSequence[arrLen - 1]);

        System.out.println(sb);
    }
}
