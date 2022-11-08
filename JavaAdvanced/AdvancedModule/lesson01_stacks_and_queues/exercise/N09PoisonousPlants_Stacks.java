package lesson01_stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class N09PoisonousPlants_Stacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        Deque<Integer> plants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(plantsCount)
                .map(Integer::parseInt)
                .forEach(plants::push);

        int days = 0;
        boolean plantDied;
        do {
            plantDied = false;
            Deque<Integer> survivedPlants = new ArrayDeque<>();
            while (plants.size() > 1) {
                Integer current = plants.pop();
                Integer left = plants.peek();
                //noinspection ConstantConditions
                if (current <= left) survivedPlants.push(current);
                else plantDied = true;
            }
            survivedPlants.push(plants.pop());

            while (!survivedPlants.isEmpty()) plants.push(survivedPlants.pop());
            if (plantDied) days++;

        } while (plantDied);

        System.out.println(days);
    }
}
