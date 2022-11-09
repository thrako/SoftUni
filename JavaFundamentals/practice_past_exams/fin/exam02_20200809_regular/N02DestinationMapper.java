package practice_past_exams.fin.exam02_20200809_regular;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02DestinationMapper {
    public static void main(String[] args) {
        List<String> destinations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<dlmt>[=|/])(?<dest>[A-Z][A-Za-z]{2,})(\\k<dlmt>)");
        Matcher matcher = pattern.matcher(input);
        int points = 0;
        String dest;
        while (matcher.find()) {
            dest = matcher.group("dest");
            destinations.add(dest);
            points += dest.length();
        }
        System.out.printf("Destinations: %s%n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d%n", points);
    }
}
