package lesson08_text_processing.more;

import java.util.Scanner;

public class N02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        if (first > second) {
            char temp = first;
            first = second;
            second = temp;
        }
        int sum = 0;
        String str = scanner.nextLine();
        for (int i = 0, length = str.length(); i < length; i++) {
            char currCh = str.charAt(i);
            if (first < currCh && currCh < second) sum += currCh;
        }
        System.out.println(sum);
    }
}
