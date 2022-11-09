package lesson02_data_types_and_variables.more;

import java.util.Scanner;

public class N06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int balance = 0;
        for (int i = 0; i < lines; i++) {
            String input = scanner.nextLine();
            if (input.equals("(")) balance++;
            if (input.equals(")")) balance--;
            if (balance == 2 || balance == -1) break;
        }
        if (balance == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
