package lesson04_methods.exercise;

import java.util.Scanner;

public class N01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        System.out.println(getSmallestOf(a, b, c));
    }

    private static int getSmallestOf(int a, int ...args) {
        int smallest = a;
        for (int arg : args) {
            if (arg < smallest) smallest = arg;
        }
        return smallest;
    }
}
