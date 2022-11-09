package lesson03_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N09ArrayModifier {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] inputs = scanner.nextLine().split(" ");
        while (!inputs[0].equals("end")) {
            switch (inputs[0]) {
                case "swap":
                    int index1 = Integer.parseInt(inputs[1]);
                    int index2 = Integer.parseInt(inputs[2]);
                    swap(index1, index2);
                    break;
                case "multiply":
                    int multiplicandIndex = Integer.parseInt(inputs[1]);
                    int multiplierIndex = Integer.parseInt(inputs[2]);
                    multiply(multiplicandIndex, multiplierIndex);
                    break;
                case "decrease":
                    decreaseAll(1);
                    break;
                default:
                    System.out.println("Command not found!");
            }
            inputs = scanner.nextLine().split(" ");
        }
        StringBuilder sb = new StringBuilder();
        int lenght = arr.length;
        for (int i = 0; i < lenght - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[lenght-1]);
        System.out.println(sb);
    }

    private static void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void multiply(int multiplicandIndex, int multiplierIndex) {
        arr[multiplicandIndex] *= arr[multiplierIndex];
    }

    private static void decreaseAll(int number) {
        for (int i = 0, length = arr.length; i < length; i++) {
            arr[i] -= number;
        }
    }
}
