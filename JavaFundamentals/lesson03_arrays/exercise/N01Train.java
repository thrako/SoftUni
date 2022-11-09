package lesson03_arrays.exercise;

import java.util.Scanner;

public class N01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numWagons = Integer.parseInt(scanner.nextLine());
        int[] wagons = new int[numWagons];

        for (int i = 0; i < numWagons; i++) {
            wagons[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = 0;
        for (int i = 0; i < numWagons; i++) {
            sum += wagons[i];
            System.out.print(wagons[i] + " ");
        }
        System.out.printf("%n%d", sum);
    }
}
