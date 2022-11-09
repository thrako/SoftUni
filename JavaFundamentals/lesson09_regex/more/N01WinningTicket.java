package lesson09_regex.more;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().trim().split("[,\\s]+");
        String[] symbols = {"@", "#", "$", "^"};
        Pattern pattern;
        Matcher matcher;
        int leftCount;
        int rightCount;

        ticketCheck:
        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String left = ticket.substring(0, 10);
                String right = ticket.substring(10, 20);
                for (String symbol : symbols) {
                    String regex = String.format("(?<currSymbol>[\\%s]{6,})", symbol);
                    pattern = Pattern.compile(regex);
                    leftCount = rightCount = 0;
                    matcher = pattern.matcher(left);
                    if (matcher.find()) leftCount = matcher.group("currSymbol").length();
                    matcher = pattern.matcher(right);
                    if (matcher.find()) rightCount = matcher.group("currSymbol").length();

                    if (leftCount == 10 && rightCount == 10) {
                        System.out.printf("ticket \"%s\" - 10%s Jackpot!%n", ticket, symbol);
                        continue ticketCheck;
                    } else if (leftCount >= 6 && rightCount >= 6) {
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, Math.min(leftCount, rightCount), symbol);
                        continue ticketCheck;
                    }
                }
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            }
        }
    }
}
