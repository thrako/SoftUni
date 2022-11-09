package lesson04_methods.lab;

import java.util.Scanner;

public class N07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringToRepeat = scanner.nextLine();
        int times = Integer.parseInt(scanner.nextLine());
        String repeatedStr = repeat(stringToRepeat, times);
        System.out.println(repeatedStr);
    }

    private static String repeat(String str, int times) {
        return str.repeat(times);
    }
}
