package lesson01_stacks_and_queues.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N09PoisonousPlants_Queues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        Queue<Integer> plants = new ArrayDeque<>();
        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(plantsCount)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(input);
        Collections.addAll(plants, input.toArray(new Integer[0]));

        int days = 0;
        boolean plantDied;
        do {
            plantDied = false;
            Queue<Integer> survived = new ArrayDeque<>();
            while (!plants.isEmpty()) {
                Integer right = plants.poll();
                if (plants.isEmpty() || right <= plants.peek()) {
                    survived.offer(right);
                } else {
                    plantDied = true;
                }
            }
            if (plantDied) days++;
            plants = survived;
        } while (plantDied);

        System.out.println(days);
    }
}
