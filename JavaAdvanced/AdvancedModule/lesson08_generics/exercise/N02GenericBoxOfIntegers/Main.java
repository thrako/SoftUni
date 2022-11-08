package lesson08_generics.exercise.N02GenericBoxOfIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println(new Box<>(Integer.parseInt(scanner.nextLine())));
        }
    }
}
