package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        int headsetRate = 2;
        int mouseRate = 3;
        int keyboardRate = headsetRate * mouseRate;
        int displayRate = keyboardRate * 2;
        int headsetCount = lostGamesCount / headsetRate;
        int mouseCount = lostGamesCount / mouseRate;
        int keyboardCount = lostGamesCount / keyboardRate;
        int displayCount = lostGamesCount / displayRate;
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double totalBill = headsetCount * headsetPrice +
                mouseCount * mousePrice +
                keyboardCount * keyboardPrice +
                displayCount * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", totalBill);
    }
}
