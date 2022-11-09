package lesson04_methods.more;

import java.util.Scanner;

public class N05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int negatives = 0;
        if (num1 < 0) negatives++;
        if (num2 < 0) negatives++;
        if (num3 < 0) negatives++;

        if (num1 == 0 || num2 == 0 || num3 == 0) System.out.println("zero");
        else if (negatives %2 != 0) System.out.println("negative");
        else System.out.println("positive");
    }
}
