package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N04PrintAndSum {
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
