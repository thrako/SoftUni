package lesson02datatypesandvariables.lab;

import java.util.Scanner;

public class N08_Lower_Or_Upper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(ch)) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
