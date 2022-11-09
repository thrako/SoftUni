package lesson08_text_processing.exercise;

import java.util.Scanner;

public class N08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        double sum = 0;
        StringBuilder strBld = new StringBuilder();

        for (String string : strings) {
            int idx = 0;
            int length = string.length();
            while (idx < length && Character.isAlphabetic(string.charAt(idx))) strBld.append(string.charAt(idx++));
            String prefix = strBld.toString();
            strBld.setLength(0);

            while (idx < length && Character.isDigit(string.charAt(idx))) strBld.append(string.charAt(idx++));
            double number = Double.parseDouble(strBld.toString());
            strBld.setLength(0);

            while (idx < length && Character.isAlphabetic(string.charAt(idx))) strBld.append(string.charAt(idx++));
            String suffix = strBld.toString();
            strBld.setLength(0);

            if (Character.isUpperCase(prefix.charAt(0))) {
                int operand = prefix.charAt(0) - 64;
                number /= operand;
            } else {
                int operand = prefix.charAt(0) - 96;
                number *= operand;
            }

            if (Character.isUpperCase(suffix.charAt(0))) {
                int operand = suffix.charAt(0) - 64;
                number -= operand;
            } else {
                int operand = suffix.charAt(0) - 96;
                number += operand;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}
