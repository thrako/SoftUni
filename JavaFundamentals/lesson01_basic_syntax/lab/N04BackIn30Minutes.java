package lesson01_basic_syntax.lab;

import java.util.Scanner;

public class N04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        minute += 30;

        if (minute > 59) {
            minute %= 60;
            hour++;
        }

        if (hour > 23) {
            hour %= 24;
        }

        if (minute < 10) {
            System.out.printf("%d:0%d", hour, minute);
        } else {
            System.out.printf("%d:%d", hour, minute);
        }
    }
}
