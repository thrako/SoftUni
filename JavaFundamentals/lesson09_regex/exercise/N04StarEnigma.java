package lesson09_regex.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N04StarEnigma {
    public static void main(String[] args) {
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile("([starSTAR])");
            Matcher matcher = pattern.matcher(line);
            int key = 0;
            while (matcher.find()) key++;

            StringBuilder strBld = new StringBuilder();
            int finalKey = key;
            line.chars()
                    .mapToObj(c -> (char) (c - finalKey))
                    .forEach(strBld::append);

            String decrypted = strBld.toString();
            pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*?:(?<people>[\\d]+)[^@\\-!:>]*?!(?<type>[A|D])![^@\\-!:>]*?->(?<soldiers>[\\d]+)");
            matcher = pattern.matcher(decrypted);
            if (matcher.find()) {
                String name = matcher.group("name");
                //int people = Integer.parseInt(matcher.group("people")); //not necessary for the solution
                String type = matcher.group("type");
                //int soldiers = Integer.parseInt(matcher.group("soldiers")); //not necessary for the solution
                if ("A".equals(type)) attacked.add(name);
                else if ("D".equals(type)) destroyed.add(name);
            }
        }

        System.out.printf("Attacked planets: %d%n", attacked.size());
        Collections.sort(attacked);
        attacked.forEach(n -> System.out.printf("-> %s%n", n));

        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        Collections.sort(destroyed);
        destroyed.forEach(n -> System.out.printf("-> %s%n", n));
    }
}
