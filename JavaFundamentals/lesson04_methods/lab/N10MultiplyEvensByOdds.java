package lesson04_methods.lab;

import java.util.Scanner;

public class N10MultiplyEvensByOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(getMultipleOfEvensAndOdds(number));
    }

    private static int getMultipleOfEvensAndOdds(int num) {
        int absNum = Math.abs(num);
        int evensSum = Integer.toString(absNum).chars().map(c -> c - '0').filter(e -> e % 2 == 0).sum();
        int oddsSum = Integer.toString(absNum).chars().map(c -> c - '0').filter(e -> e % 2 == 1).sum();
        return evensSum * oddsSum;
    }
}
