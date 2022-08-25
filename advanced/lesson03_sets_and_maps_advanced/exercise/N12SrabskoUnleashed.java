package lesson03_sets_and_maps_advanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N12SrabskoUnleashed {
    public static void main(String[] args) {
        Map<String, Map<String, Long>> venues = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<singer>\\b.+\\b){1,3} @(?<venue>\\b.+\\b){1,3} (?<price>\\b\\d+\\b) (?<count>\\b\\d+\\b)");
        Matcher matcher;

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0L);
                long subtotal = venues.get(venue).get(singer);
                venues.get(venue).put(singer, subtotal + (long) price * count);
            }
            input = scanner.nextLine();
        }

        venues.forEach((venue, singer) -> {
            System.out.println(venue);
            singer.entrySet().stream()
                    .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
