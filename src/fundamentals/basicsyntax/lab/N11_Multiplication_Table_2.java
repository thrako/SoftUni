package basicsyntax.lab;

import java.util.Scanner;

public class N11_Multiplication_Table_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int multiplier = scanner.nextInt();

        do {
            System.out.printf("%d X %d = %d",
                    number,
                    multiplier,
                    number * multiplier);
            System.out.println();
            multiplier++;
        } while (multiplier < 11);
    }
}
