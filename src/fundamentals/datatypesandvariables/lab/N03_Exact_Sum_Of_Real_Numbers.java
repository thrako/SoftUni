package datatypesandvariables.lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class N03_Exact_Sum_Of_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = BigDecimal.valueOf(0);
        for (int i = 0; i < count; i++) {
            BigDecimal input = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine())).stripTrailingZeros();
            sum = sum.add(input);
        }
        sum.stripTrailingZeros();
        System.out.println(sum);
    }
}
