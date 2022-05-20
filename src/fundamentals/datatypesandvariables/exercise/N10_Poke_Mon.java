package datatypesandvariables.exercise;

import java.util.Scanner;

public class N10_Poke_Mon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhFactor = Integer.parseInt(scanner.nextLine());
        int remainingPower = pokePower;
        int pokesCount = 0;

        while (remainingPower >= distance) {
            remainingPower -= distance;
            pokesCount++;
            if ((double) remainingPower == ((double) pokePower / 2) && exhFactor != 0) {
                remainingPower /= exhFactor;
            }
        }
        System.out.println(remainingPower);
        System.out.println(pokesCount);
    }
}
