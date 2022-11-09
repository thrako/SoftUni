package practice_past_exams.mid.exam02_20200705_regular;

import java.util.Arrays;
import java.util.Scanner;

public class N02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "swap":
                    swap(intArray, tokens[1], tokens[2]);
                    break;
                case "multiply":
                    multiply(intArray, tokens[1], tokens[2]);
                    break;
                case "decrease":
                    decreaseAll(intArray, 1);
                    break;
            }
            input = scanner.nextLine();
        }
        print(intArray);
    }

    private static void print(int[] intArray) {
        StringBuilder strBld = new StringBuilder();
        for (int i = 0, length = intArray.length; i < length - 1; i++) {
            strBld.append(intArray[i]).append(", ");
        }
        strBld.append(intArray[intArray.length - 1]);
        System.out.println(strBld);
    }

    private static void decreaseAll(int[] intArray, int num) {
        for (int i = 0, length = intArray.length; i < length; i++) {
            intArray[i] -= num;
        }
    }

    private static void multiply(int[] intArray, String token1, String token2) {
        int idx1 = Integer.parseInt(token1);
        int idx2 = Integer.parseInt(token2);
        intArray[idx1] *= intArray[idx2];
    }

    private static void swap(int[] intArray, String token1, String token2) {
        int idx1 = Integer.parseInt(token1);
        int idx2 = Integer.parseInt(token2);
        int temp = intArray[idx1];
        intArray[idx1] = intArray[idx2];
        intArray[idx2] = temp;
    }
}
