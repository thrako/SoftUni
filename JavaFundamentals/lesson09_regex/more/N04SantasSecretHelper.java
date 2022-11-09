package lesson09_regex.more;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class N04SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("[^@\\-!:>]*?@(?<name>[A-Za-z]+)[^@\\-!:>]*?!(?<behaviour>[G|N])![^@\\-!:>]*?");
        Matcher matcher;

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            var decrypted = input.chars()
                    .mapToObj(c -> String.valueOf((char) (c - key)))
                    .collect(Collectors.joining());
            matcher = pattern.matcher(decrypted);
            if (matcher.find() && matcher.group("behaviour").equals("G")) System.out.println(matcher.group("name"));

            input = scanner.nextLine();
        }
    }
}
