package practice_past_exams.fin.exam04_20200404_regular;

import java.util.Scanner;
import java.util.regex.Pattern;

public class N01PasswordReset {
    private static final String END = "Done";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String[] tokens = scanner.nextLine().split(" ");
        while (!END.equals(tokens[0])) {
            switch (tokens[0]) {
                case "TakeOdd":
                    password = takeOdd(password);
                    break;
                case "Cut":
                    int idx = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    password = cut(password, idx, length);
                    break;
                case "Substitute":
                    String target = tokens[1];
                    String replacement = tokens[2];
                    password = substitute(password, target, replacement);
                    break;
            }
            tokens = scanner.nextLine().split(" ");
        }
        System.out.printf("Your password is: %s", password);
    }

    private static String takeOdd(String password) {
        StringBuilder strBld = new StringBuilder();
        for (int i = 1; i < password.length(); i = i + 2) {
            strBld.append(password.charAt(i));
        }
        password = strBld.toString();
        System.out.println(password);
        return password;
    }

    private static String cut(String password, int idx, int length) {
        String subStr = password.substring(idx, idx + length);
        password = password.replaceFirst(Pattern.quote(subStr), "");
        System.out.println(password);
        return password;
    }

    private static String substitute(String password, String target, String replacement) {
        if (password.contains(target)) {
            password = password.replace(target, replacement);
            System.out.println(password);
        } else {
            System.out.println("Nothing to replace!");
        }
        return password;
    }
}
