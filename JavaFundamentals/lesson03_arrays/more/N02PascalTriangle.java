package lesson03_arrays.more;

import java.util.Scanner;

public class N02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        long[] previous = new long[0];
        for (int row = 1; row <= numLines; row++) {
            long[] current = new long[previous.length + 1];
            current[0] = 1;
            current[current.length - 1] = 1;
            double mid = current.length / 2.0;
            for (int i = 1; i < mid; i++) {
                current[i] = previous[i] + previous[i-1];
                current[current.length - 1 - i] = current[i];
            }
            for(long num : current) {
                System.out.print(num + " ");
            }
            System.out.println();
            previous = current;
        }
    }
}