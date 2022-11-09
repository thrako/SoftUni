package practice_past_exams.fin.exam03_20200410_retake;

import java.util.Scanner;
import java.util.regex.Pattern;

public class N01SecretChat {
    private static final String END = "Reveal";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String[] tokens = scanner.nextLine().split(":\\|:");
        while (!END.equals(tokens[0])) {
            boolean foundError = false;
            switch (tokens[0]) {
                case "InsertSpace":
                    int idx = Integer.parseInt(tokens[1]);
                    String first = message.substring(0, idx);
                    String second = message.substring(idx);
                    message = first + " " + second;
                    break;
                case "Reverse":
                    String subStr = tokens[1];
                    if (message.contains(subStr)) {
                        message = new StringBuilder(subStr)
                                .reverse()
                                .insert(0, message.replaceFirst(Pattern.quote(subStr), ""))
                                .toString();
                    } else {
                        foundError = true;
                    }
                    break;
                case "ChangeAll":
                    String target = tokens[1];
                    String replacement = tokens[2];
                    message = message.replace(target, replacement);
                    break;
                default:
            }
            System.out.println((foundError) ? "error" : message);
            tokens = scanner.nextLine().split(":\\|:");
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
