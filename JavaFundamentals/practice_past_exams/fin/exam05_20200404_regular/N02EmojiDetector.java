package practice_past_exams.fin.exam05_20200404_regular;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        Pattern digitPatter = Pattern.compile("[\\d]");
        Matcher matcher = digitPatter.matcher(inputStr);
        long coolThreshold = 1L;
        while (matcher.find()) coolThreshold *= Long.parseLong(matcher.group());

        List<String> emojies = new ArrayList<>();
        Pattern emojiPattern = Pattern.compile("(?<prefix>[:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        matcher = emojiPattern.matcher(inputStr);
        int counter = 0;
        while (matcher.find()) {
            counter++;
            String emoji = matcher.group("emoji");
            String prefix = matcher.group("prefix");
            long threshold = sumAscii(emoji);
            if (threshold >= coolThreshold) {
                emojies.add(prefix + emoji + prefix);
            }
        }
        System.out.printf("Cool threshold: %s%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);
        for (String emoji : emojies) {
            System.out.println(emoji);
        }
    }

    private static long sumAscii(String emoji) {
        long sum = 1L;
        for (int i = 0, length = emoji.length(); i < length; i++) {
            sum += emoji.charAt(i);
        }
        return sum;
    }
}
