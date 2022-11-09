package lesson05_lists.more;

import java.util.Arrays;
import java.util.Scanner;

public class N01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(N01Messaging::applySumToInt)
                .toArray();
        StringBuilder encryptedMsg = new StringBuilder(scanner.nextLine());
        StringBuilder decryptedMsg = new StringBuilder();
        for (int number : numbers) {
            decryptedMsg.append(findAndRemoveChar(encryptedMsg, number));
        }
        System.out.println(decryptedMsg);
    }

    private static int applySumToInt(String element) {
        int sum = 0;
        for (int i = 0, length = element.length(); i < length; i++) {
            String symbol = String.valueOf(element.charAt(i));
            sum += Integer.parseInt(symbol);
        }
        return sum;
    }

    private static char findAndRemoveChar(StringBuilder encryptedMsg, int number) {
        int length = encryptedMsg.length();
        int idx = (number < length) ? number : number % length;
        char symbol = encryptedMsg.charAt(idx);
        encryptedMsg.deleteCharAt(idx);
        return symbol;
    }
}
