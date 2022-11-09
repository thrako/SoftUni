package lesson09_regex.more;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N03PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split("\\|");
        Pattern firstPattern, secondPattern, thirdPattern;
        Matcher matcher;

        firstPattern = Pattern.compile("(?<ch>[#$%*&])(?<caps>[A-Z]+)(\\1)");
        matcher = firstPattern.matcher(parts[0]);
        String caps = (matcher.find()) ? matcher.group("caps") : "";

        for (int capChar : caps.chars().toArray()) {
            secondPattern = Pattern.compile(String.format("%d:(?<value>[\\d]{2})", capChar));
            matcher = secondPattern.matcher(parts[1]);
            int symbolsCount = (matcher.find()) ? Integer.parseInt(matcher.group("value")) : 0;

            thirdPattern = Pattern.compile(String.format("(^|\\s+)(?<word>%s[^\\s]{%d})($|\\s+)", (char) capChar, symbolsCount));
            matcher = thirdPattern.matcher(parts[2]);
            if (matcher.find()) System.out.println(matcher.group("word"));
        }
    }
}
