package basicsyntax.exercise;

import java.util.Scanner;

public class N11_Rage_Expenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        int headsetRate = 2;
        int mouseRate = 3;
        int keyboardRate = headsetRate * mouseRate;
        int displayRate = keyboardRate * 2;
        int headsetCount = (int) Math.ceil(lostGamesCount / headsetRate);
        int mouseCount = (int) Math.ceil(lostGamesCount / mouseRate);
        int keyboardCount = (int) Math.ceil(lostGamesCount / keyboardRate);
        int displayCount = (int) Math.ceil(lostGamesCount / displayRate);
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
