package lesson09_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9]+[-_.]*[a-zA-Z0-9]*?@[\\w-_.]+\\.[\\w-_]+\\b");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        while (matcher.find()) System.out.println(matcher.group());
    }
}
