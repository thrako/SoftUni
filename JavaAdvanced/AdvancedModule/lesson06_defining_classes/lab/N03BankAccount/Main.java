package lesson06_defining_classes.lab.N03BankAccount;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static Map<Integer, BankAccount> accounts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        accounts = new HashMap<>();
        var input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Create": {
                    createAccount();
                    break;
                }
                case "Deposit": {
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    deposit(id, amount);
                    break;
                }
                case "SetInterest": {
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                }
                case "GetInterest": {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    getInterest(id, years);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected command: " + command);
            }
            input = scanner.nextLine();
        }

    }

    private static void createAccount() {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account ID%d created%n", account.getId());
    }

    private static void deposit(int id, double amount) {
        try {
            BankAccount account = accounts.get(id);
            account.deposit(amount);
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.printf("Deposited %s to ID%d%n", df.format(amount), account.getId());
        } catch (NullPointerException e) {
            System.out.println("Account does not exist");
        }
    }

    private static void getInterest(int id, int years) {
        try {
            System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
        } catch (NullPointerException e) {
            System.out.println("Account does not exist");
        }
    }
}
