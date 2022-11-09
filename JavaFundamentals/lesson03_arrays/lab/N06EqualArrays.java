package lesson03_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArr = intArrayFromSpaceSeparatedString(scanner.nextLine());
        int[] secondArr = intArrayFromSpaceSeparatedString(scanner.nextLine());
        boolean areIdentical = true;
        int sum = 0;
        if (firstArr.length == secondArr.length) {
            for (int i = 0; i < firstArr.length; i++) {
                if (firstArr[i] == secondArr[i]) {
                    sum += firstArr[i];
                } else {
                    areIdentical = false;
                    System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                    break;
                }
            }
        } else {
            areIdentical = false;
        }

        if (areIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }

    private static int[] intArrayFromSpaceSeparatedString(String str) {
        return Arrays
               .stream(str.split(" "))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
}
