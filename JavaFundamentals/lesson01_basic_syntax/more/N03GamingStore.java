package lesson01_basic_syntax.more;

import java.util.Scanner;

public class N03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double balance = budget;
        String input = scanner.nextLine();
        while (!input.equals("Game Time")) {
            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (balance < 39.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 39.99;
                        System.out.printf("Bought %s%n", input);
                    }
                    break;
                case "CS: OG":
                    if (balance < 15.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 15.99;
                        System.out.printf("Bought %s%n", input);
                    }
                    break;
                case "Zplinter Zell":
                    if (balance < 19.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 19.99;
                        System.out.printf("Bought %s%n", input);
                    }
                    break;
                case "Honored 2":
                    if (balance < 59.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 59.99;
                        System.out.printf("Bought %s%n", input);
                    }
                    break;
                case "RoverWatch":
                    if (balance < 29.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 29.99;
                        System.out.printf("Bought %s%n", input);
                    }
                    break;
                default:
                    System.out.println("Not Found");
            }
            if (balance == 0) {
                System.out.println("Out of money!");
                break;
            } else {
                input = scanner.nextLine();
            }
        }
        if (balance != 0) System.out.printf("Total spent: $%.2f. Remaining: $%.2f", budget - balance, balance);
    }
}

