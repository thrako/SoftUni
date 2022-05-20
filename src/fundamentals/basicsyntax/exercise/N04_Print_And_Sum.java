package basicsyntax.exercise;

import java.util.Scanner;

public class N04_Print_And_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();
        long sum = 0;
        for (int i = startNum; i <= endNum; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.printf("%nSum: %d", sum);
    }
}
