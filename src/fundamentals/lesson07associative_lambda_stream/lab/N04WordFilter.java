package lesson07associative_lambda_stream.lab;

import java.util.Arrays;
import java.util.Scanner;

public class N04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(e -> e.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
