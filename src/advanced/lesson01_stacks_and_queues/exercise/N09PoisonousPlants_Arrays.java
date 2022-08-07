package lesson01_stacks_and_queues.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N09PoisonousPlants_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean[] deadPlants = new boolean[plantsCount];

        int days = 0;
        boolean plantDied = true;
        while (plantDied) {
            plantDied = false;
            for (int i = plantsCount - 1; i >= 1; i--) {
                if (deadPlants[i]) continue;
                int left = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 0 ; j--) {
                    if (!deadPlants[j]) {
                        left = plants[j];
                        break;
                    }
                }
                if (plants[i] > left) {
                    deadPlants[i] = true;
                    plantDied = true;
                }
            }
            if (plantDied) days++;
        }
        System.out.println(days);
    }
}
