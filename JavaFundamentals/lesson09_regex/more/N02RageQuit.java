package lesson09_regex.more;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<nonNumeric>[^\\d]+)(?<numeric>[\\d]+)");
        Matcher matcher = pattern.matcher(input.toUpperCase());
        StringBuilder strBld = new StringBuilder();
        while (matcher.find()) {
            String symbols = matcher.group("nonNumeric");
            int times = Integer.parseInt(matcher.group("numeric"));
            if (times != 0) strBld.append(symbols.repeat(times));
        }
        String result = strBld.toString();
        long distinctCount = result.chars().distinct().count();
        System.out.printf("Unique symbols used: %d%n%s%n",distinctCount, result);
    }
}
