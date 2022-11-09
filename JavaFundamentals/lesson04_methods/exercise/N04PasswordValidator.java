package lesson04_methods.exercise;

import java.util.Scanner;

public class N04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (isValid(password)) System.out.println("Password is valid");
    }

    private static boolean isValid(String password) {
        boolean validFlag = true;
        if (!isLengthValid(password)) validFlag = false;
        if (!containsOnlyValidChars(password)) validFlag = false;
        if (!hasEnoughDigits(password)) validFlag = false;
        return validFlag;
    }

    private static boolean isLengthValid(String password) {
        int length = password.length();
        if (length < 6 || length > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
        return true;
    }

    private static boolean containsOnlyValidChars(String password) {
        for (int i = 0, length = password.length(); i < length; i++) {
            if (!Character.isAlphabetic(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    private static boolean hasEnoughDigits(String password) {
        int digitsCount = 0;
        for (int i = 0, length = password.length(); i < length; i++) {
            if (Character.isDigit(password.charAt(i))) digitsCount++;
        }
        if (digitsCount < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
        return true;
    }
}
