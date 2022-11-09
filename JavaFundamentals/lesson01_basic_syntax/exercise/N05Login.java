package lesson01_basic_syntax.exercise;

import java.util.Scanner;

public class N05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = getPassword(username);
        boolean isLoggedIn = false;
        String input = scanner.nextLine();
        int counter = 1;

        while (counter < 4) {

            if (input.equals(password)) {
                isLoggedIn = true;
                break;
            } else {
                input = scanner.nextLine();
                counter++;
                System.out.println("Incorrect password. Try again.");
            }
        }

        if (isLoggedIn) {
            System.out.printf("User %s logged in.", username);
        } else {
            System.out.printf("User %s blocked!", username);
        }
    }

    private static String getPassword(String username) {
        String password = "";
        int len = username.length() - 1;
        for (int i = len; i >= 0; i--) {
            password = password.concat(Character.toString(username.charAt(i)));
        }
        return password;
    }
}
