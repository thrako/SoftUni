package lesson03_sets_and_maps_advanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> nameEmailMap = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("[.](?:[c][o][m]|[u][k|s])$", Pattern.CASE_INSENSITIVE);
        String input = scanner.nextLine();
        while(!"stop".equals(input)) {
            String name = input;
            String email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (!matcher.find()) {
                nameEmailMap.put(name, email);
            }
            input = scanner.nextLine();
        }

        for (var entry : nameEmailMap.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
