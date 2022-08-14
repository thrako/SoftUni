package my_exams.fin20220807;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<prefix>.*)>(?<digits>[\\d]{3})\\|(?<lowers>[a-z]{3})\\|(?<caps>[A-Z]{3})\\|(?<symbols>[^><]{3})<(?<suffix>\\k<prefix>)");
        Matcher matcher;

        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String input = scanner.nextLine();
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String encrypted = matcher.group("digits")
                        .concat(matcher.group("lowers"))
                        .concat(matcher.group("caps"))
                        .concat(matcher.group("symbols"));
                System.out.printf("Password: %s%n", encrypted);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
