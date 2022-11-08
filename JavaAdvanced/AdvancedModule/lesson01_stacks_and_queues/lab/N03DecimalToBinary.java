package lesson01_stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decInt = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (decInt > 0) {
            stack.push(String.valueOf(decInt % 2));
            decInt /= 2;
        }
        System.out.println(String.join("", stack));
    }
}
