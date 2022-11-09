package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N07ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        for (int i = 0; i < 3; i++) {
            String ch = scanner.nextLine();
            output = ch.concat(" ").concat(output);
        }
        System.out.println(output);
    }
}
