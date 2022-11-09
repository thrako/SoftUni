package lesson03_arrays.exercise;

import java.util.Scanner;

public class N02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");
        for (String val2 : arr2) {
            for (String val1 : arr1) {
                if (val1.equals(val2)) System.out.print(val1 + " ");
            }
        }
    }
}
