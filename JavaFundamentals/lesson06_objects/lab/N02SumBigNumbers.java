package lesson06_objects.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class N02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger firstBig = new BigInteger(scanner.nextLine());
        BigInteger secondBig = new BigInteger(scanner.nextLine());
        System.out.println(firstBig.add(secondBig));
    }
}
