package practice_past_exams.mid.exam04_20200229_regular;

import java.util.Arrays;
import java.util.Scanner;

public class N03HeartDelivery {
    private static final String END = "Love!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] houses = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int arrLength = houses.length, idx = 0, counter = 0;
        String[] tokens = scanner.nextLine().split("\\s+");
        while (!END.equals(tokens[0])) {
            idx += Integer.parseInt(tokens[1]);
            if (idx >= arrLength) idx = 0;
            houses[idx] -= 2;
            if (houses[idx] < 0) System.out.printf("Place %d already had Valentine's day.%n", idx);
            if (houses[idx] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", idx);
                counter++;
            }
            tokens = scanner.nextLine().split("\\s+");
        }
        System.out.printf("Cupid's last position was %d.%n", idx);
        if (counter == arrLength) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", arrLength - counter);
        }
    }
}
