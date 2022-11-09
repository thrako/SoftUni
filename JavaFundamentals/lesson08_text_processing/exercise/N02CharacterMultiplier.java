package lesson08_text_processing.exercise;

import java.util.Scanner;

public class N02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String shorter, longer;
        if (strings[0].length() < strings[1].length()) {
            shorter = strings[0];
            longer = strings[1];
        } else {
            shorter = strings[1];
            longer = strings[0];
        }
        long sum = getSum(shorter, longer);
        System.out.println(sum);
    }

    private static long getSum(String shorter, String longer) {
        long sum = 0;
        int shortLen = shorter.length();
        int longLen = longer.length();
        for (int i = 0; i < shortLen; i++) {
            sum += (long) shorter.charAt(i) * longer.charAt(i);
        }
        for (int i = shortLen; i < longLen; i++) {
            sum += longer.charAt(i);
        }
        return sum;
    }
}
