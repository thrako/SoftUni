package lesson09_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N03SoftUniBarIncome {
    private static final String END = "end of shift";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<qty>[0-9]+)\\|[^|$%.0-9]*(?<price>[0-9]+[.]?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double sum = 0;
        String input = scanner.nextLine();
        while (!END.equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int qty = Integer.parseInt(matcher.group("qty"));
                double price = Double.parseDouble(matcher.group("price"));
                double orderTotal = qty * price;

                System.out.printf("%s: %s - %.2f%n", name, product, orderTotal);
                sum += orderTotal;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", sum);
    }
}
