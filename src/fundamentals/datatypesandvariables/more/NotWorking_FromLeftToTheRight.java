package datatypesandvariables.more;

import java.math.BigInteger;
import java.util.Scanner;

public class NotWorking_FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            BigInteger left = scanner.nextBigInteger();
            BigInteger right = scanner.nextBigInteger();
            BigInteger sum = BigInteger.valueOf(0);
            BigInteger bigger = (left.compareTo(right) > 0) ? left : right;
            while (bigger.compareTo(BigInteger.valueOf(0)) > 0) {
                sum = sum.add(bigger.remainder(BigInteger.valueOf(10)));
                bigger = bigger.divide(BigInteger.valueOf(10));
            }
            System.out.println(sum.intValue());
            //TODO ask why not working!

        }
    }
}
