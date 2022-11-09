package lesson03_arrays.more;

import java.util.Arrays;
import java.util.Scanner;

public class N01EncryptSortAndPrintArray_passable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int[] encryptions = new int[numLines];
        for (int i = 0; i < numLines; i++) {
            String name = scanner.nextLine();
            int sum = 0;
            for (int j = 0, length = name.length(); j < length; j++) {
                char c = name.charAt(j);
                if ("aAeEiIoOuU".indexOf(c) != -1) {
                    sum += (c * length);
                } else {
                    sum += (c / length);
                }
            }
            encryptions[i] = sum;
        }
        Arrays.sort(encryptions);
        for (int e : encryptions) {
            System.out.println(e);
        }
    }
}
