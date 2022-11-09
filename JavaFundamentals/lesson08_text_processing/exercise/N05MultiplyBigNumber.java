package lesson08_text_processing.exercise;

import java.util.Scanner;

public class N05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numericStr = scanner.nextLine();
        int length = numericStr.length();

        int multiplier = Integer.parseInt(scanner.nextLine());
        int carried = 0;

        StringBuilder strBld = new StringBuilder();
        if (multiplier == 0) {
            strBld.append(0);
        } else {
            int leadingZeros = 0;
            while (numericStr.charAt(leadingZeros) == '0') {
                leadingZeros++;
            }
            for (int i = 1; i <= length - leadingZeros; i++) {
                char ch = numericStr.charAt(length - i);
                int multiplied = carried + Integer.parseInt(String.valueOf(ch)) * multiplier;
                strBld.append(multiplied % 10);
                carried = multiplied / 10;
            }
            if (carried != 0) {
                strBld.append(carried);
            }
        }
        System.out.println(strBld.reverse());
    }
}
