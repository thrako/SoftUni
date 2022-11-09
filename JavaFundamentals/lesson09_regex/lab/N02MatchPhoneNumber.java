package lesson09_regex.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02MatchPhoneNumber {
    public static void main(String[] args) {
        List<String> matched = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) matched.add(matcher.group());
        System.out.println(String.join(", ", matched));
    }
}
