package lesson01_basic_syntax.more;

import java.util.Scanner;

public class N01SortNumbers02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int maximum = Math.max(num1, Math.max(num2, num3));
        int middle = (maximum == num1) ? Math.max(num2, num3) :
                (maximum == num2) ? Math.max(num1, num3) :
                        Math.max(num1, num2);
        int minimum = Math.min(num1, Math.min(num2, num3));

        System.out.printf("%d%n%d%n%d%n", maximum, middle, minimum);
    }
}
