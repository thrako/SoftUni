package lesson05_functional_programming.lab;

import java.util.Scanner;
import java.util.stream.IntStream;

public class N06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt() + 1;
        String condition = scanner.next();

        IntStream.range(start, end)
                .filter(n -> condition.equals("even") == (n % 2 == 0))
                .forEach(n -> System.out.print(n + " "));
    }
}
