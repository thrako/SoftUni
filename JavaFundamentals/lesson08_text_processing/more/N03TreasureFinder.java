package lesson08_text_processing.more;

import java.util.Arrays;
import java.util.Scanner;

public class N03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] keys = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!"find".equals(input)) {
            String decrypted = decrypt(keys, input);
            printTreasure(decrypted);
            input = scanner.nextLine();
        }
    }

    private static String decrypt(int[] keys, String input) {
        int keysLength = keys.length;
        int offset;
        StringBuilder strBld = new StringBuilder();
        for (int i = 0, length = input.length(); i < length; i++) {
            offset = keys[i % keysLength];
            strBld.append((char) (input.charAt(i) - offset));
        }
        return strBld.toString();
    }

    private static void printTreasure(String decrypted) {
        StringBuilder strBld = new StringBuilder();
        String type = "";
        String place = "";
        for (int i = 0, length = decrypted.length(); i < length; i++) {
            if (decrypted.charAt(i) == '&') {
                int idx = i + 1;
                while (idx < length && decrypted.charAt(idx) != '&') strBld.append(decrypted.charAt(idx++));
                type = strBld.toString();
                strBld.setLength(0);
                i = idx;
            } else if (decrypted.charAt(i) == '<') {
                int idx = i + 1;
                while (idx < length && decrypted.charAt(idx) != '>') strBld.append(decrypted.charAt(idx++));
                place = strBld.toString();
                strBld.setLength(0);
                i = idx;
            }
        }
        System.out.printf("Found %s at %s%n", type, place);
    }
}
