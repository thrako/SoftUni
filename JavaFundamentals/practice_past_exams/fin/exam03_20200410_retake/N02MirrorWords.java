package practice_past_exams.fin.exam03_20200410_retake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        List<String> mirrors = new ArrayList<>();
        Pattern mirrorPattern = Pattern.compile("(?<ch>[#|@])(?<word>[a-zA-Z]{3,})(\\k<ch>)(\\k<ch>)(?<mirror>[a-zA-Z]{3,})(\\k<ch>)");
        Matcher mirrorMatcher = mirrorPattern.matcher(inputStr);
        int counter = 0;
        while (mirrorMatcher.find()) {
            counter++;
            String word = mirrorMatcher.group("word");
            String mirror = mirrorMatcher.group("mirror");
            if (word.equals(new StringBuilder(mirror).reverse().toString())) {
                mirrors.add(word + " <=> " + mirror);
            }
        }

        if (counter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", counter);
        }

        if (mirrors.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.printf("The mirror words are:%n" +
                              "%s%n", String.join(", ", mirrors));
        }
    }
}
