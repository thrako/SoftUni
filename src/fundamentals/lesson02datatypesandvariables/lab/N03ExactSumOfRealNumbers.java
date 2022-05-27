package lesson02datatypesandvariables.lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class N03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = BigDecimal.valueOf(0);
        for (int i = 0; i < count; i++) {
            BigDecimal input = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine())).stripTrailingZeros();
            sum = sum.add(input);
        }

        System.out.println(sum);
    }
}
