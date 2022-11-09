package practice_past_exams.mid.exam01_20200812_retake;

import java.util.Arrays;
import java.util.Scanner;

public class N02TheLift {
    private final static int cabinCapacity = 4;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queueCount = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int currentCapacity = (lift.length * cabinCapacity) - Arrays.stream(lift).sum();
        if (queueCount >= currentCapacity) {
            if (queueCount > currentCapacity) {
                System.out.printf("There isn't enough space! %d people in a queue!%n", queueCount - currentCapacity);
            }
            Arrays.fill(lift, 4);
        } else {
            int counter = 0;
            while (queueCount > 0) {
                int freeSeats = cabinCapacity - lift[counter];
                lift[counter++] += Math.min(queueCount, freeSeats);
                queueCount -= freeSeats;
            }
            System.out.println("The lift has empty spots!");
        }
        StringBuilder strBld = new StringBuilder();
        for (int i = 0, length = lift.length; i < length; i++) {
            strBld.append(lift[i]);
            if (i < length - 1) {
                strBld.append(" ");
            }
        }
        System.out.println(strBld);
    }
}
