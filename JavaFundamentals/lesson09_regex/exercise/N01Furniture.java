package lesson09_regex.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N01Furniture {
    private static final String END = "Purchase";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "[>]{2}(?<item>[A-Za-z]+)[<]{2}(?<price>[\\d]+[.]?[\\d]*)[!](?<qty>[\\d]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        List<String> boughtItems = new ArrayList<>();
        double sum = 0;
        while(!END.equals(input)) {
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                String item = matcher.group("item");
                boughtItems.add(item);
                double price = Double.parseDouble(matcher.group("price"));
                int qty = Integer.parseInt(matcher.group("qty"));
                sum += price * qty;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String item : boughtItems) System.out.println(item);
        System.out.printf("Total money spend: %.2f", sum);

    }
}
