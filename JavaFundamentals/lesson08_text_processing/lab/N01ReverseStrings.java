package lesson08_text_processing.lab;

import java.util.Scanner;

public class N01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder strBld = new StringBuilder();
        String line = scanner.nextLine();
        while(!"end".equals(line)) {
            String reversedLine = reverse(line);
            strBld.append(line).append(" = ").append(reversedLine);
            System.out.println(strBld);
            strBld.setLength(0);
            line = scanner.nextLine();
        }
    }

    private static String reverse(String line) {
        StringBuilder strBld = new StringBuilder();
        return strBld.append(line).reverse().toString();
    }
}
