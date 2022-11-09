package lesson02_data_types_and_variables.lab;

import java.util.Scanner;

public class N06CharsToStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        for (int i = 0; i < 3; i++) {
            String ch = scanner.nextLine();
            output = output.concat(ch);
        }
        System.out.println(output);
    }
}
