package lesson01_basic_syntax.more;

import java.util.Scanner;

public class N01SortNumbers {
    public static void main(String[] args) {
        int first, second, third;

        Scanner scanner = new Scanner(System.in);

        first = Integer.parseInt(scanner.nextLine());


        int num2 = Integer.parseInt(scanner.nextLine());
        if (num2 > first) {
            second = first;
            first = num2;
        } else {
            second = num2;
        }

        int num3 = Integer.parseInt(scanner.nextLine());
        if (num3 > first) {
            third = second;
            second = first;
            first = num3;
        } else if (num3 > second) {
            third = second;
            second = num3;
        } else {
            third = num3;
        }

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
