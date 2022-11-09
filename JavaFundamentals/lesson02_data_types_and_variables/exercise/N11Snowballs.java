package lesson02_data_types_and_variables.exercise;

import java.util.Scanner;

public class N11Snowballs {
    public static void main(String[] args) {
        int recSnow = 0;
        int recTime = 0;
        int recQlty = 0;
        double recValue = 0;

        Scanner scanner = new Scanner(System.in);
        int numBalls = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numBalls; i++) {
            int currSnow = Integer.parseInt(scanner.nextLine());
            int currTime = Integer.parseInt(scanner.nextLine());
            int currQlty = Integer.parseInt(scanner.nextLine());
            double currValue = Math.pow(((double) currSnow / currTime), currQlty);
            if (currValue > recValue) {
                recSnow = currSnow;
                recTime = currTime;
                recQlty = currQlty;
                recValue = currValue;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", recSnow, recTime, recValue, recQlty);
    }
}
