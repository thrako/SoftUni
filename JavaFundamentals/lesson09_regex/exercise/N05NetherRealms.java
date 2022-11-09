package lesson09_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<name>[^\\s+,]+)[,\\s+]*?");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        while (matcher.find()) {
            String name = matcher.group("name");
            int health = getHealth(name);
            double damage = getDamage(name);
            System.out.printf("%s - %d health, %.2f damage%n", name, health, damage);
        }
    }

    private static int getHealth(String name) {
        Pattern pattern;
        int sum = 0;
        pattern = Pattern.compile("(?<health>[^0-9+\\-*/.])");
        Matcher lettersMatcher = pattern.matcher(name);
        while (lettersMatcher.find()) sum += lettersMatcher.group("health").charAt(0);
        return sum;
    }

    private static double getDamage(String name) {
        Pattern pattern;
        double damage = 0;
        pattern = Pattern.compile("(?<number>[-+]?[\\d]+[.]?[\\d]*)");
        Matcher numberMatcher = pattern.matcher(name);
        while (numberMatcher.find()) damage += Double.parseDouble(numberMatcher.group("number"));

        pattern = Pattern.compile("(?<multiply>[*])");
        Matcher multiplyMatcher = pattern.matcher(name);
        while (multiplyMatcher.find()) damage *= 2;

        pattern = Pattern.compile("(?<divide>[/])");
        Matcher divideMatcher = pattern.matcher(name);
        while (divideMatcher.find()) damage /= 2;
        return damage;
    }
}
