import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int headsetRate = 2;
        int mouseRate = 3;
        int keyboardRate = headsetRate * mouseRate;
        int displayRate = keyboardRate * 2;

        int lostGamesCount = Integer.parseInt(scanner.nextLine());

        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double totalBill = 0;
        for (int i = 1; i < lostGamesCount + 1; i++) {
            if (i % headsetRate == 0) {
                totalBill += headsetPrice;
            }
            if (i % mouseRate == 0) {
                totalBill += mousePrice;
            }
            if (i % keyboardRate == 0) {
                totalBill += keyboardPrice;
            }
            if (i % displayRate == 0) {
                totalBill += displayPrice;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", totalBill);
    }
}


