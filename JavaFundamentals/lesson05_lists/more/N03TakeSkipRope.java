package lesson05_lists.more;

import java.util.Scanner;

public class N03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMsg = scanner.nextLine();
        StringBuilder digitsString = new StringBuilder();
        StringBuilder nonDigitsString = new StringBuilder();

        for (int i = 0, length = encryptedMsg.length(); i < length; i++) {
            Character symbol = encryptedMsg.charAt(i);
            if (Character.isDigit(symbol)) digitsString.append(symbol);
            else nonDigitsString.append(symbol);
        }

        int idx = 0, symbolsCount;
        StringBuilder result = new StringBuilder();
        for (int i = 0, length = digitsString.length(); i < length; i++) {
            symbolsCount = Integer.parseInt(String.valueOf(digitsString.charAt(i)));
            if (i % 2 == 0) {
                for (int j = 0; j < symbolsCount; j++) {
                    if (idx + j == nonDigitsString.length()) break;
                    result.append(nonDigitsString.charAt(idx + j));
                }
            }
            idx += symbolsCount;
        }
        System.out.println(result);
    }
}
