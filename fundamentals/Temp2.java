import java.util.*;

public class Temp2 {

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(6, 5, 8, 4, 7, 10, 9));
        int length = arrList.size();
        System.out.printf("Days = %d%n", poisonousPlants(arrList));
    }

    public static int poisonousPlants(List<Integer> p) {
        // Write your code here
        ArrayList<Integer> plants = new ArrayList<>(p);
        int days = 0;
        while (true) {
            int length = plants.size();
            Deque<Integer> stack = new ArrayDeque<>();
            boolean plantDied = false;
            for (int i = length - 1; i >= 1; i--) {
                int current = plants.get(i);
                if (current <= plants.get(i - 1)) {
                    stack.push(current);
                } else {
                    plantDied = true;
                }
            }
            if (!plantDied) break;
            stack.push(plants.get(0));
            plants = new ArrayList<>(stack);
            days++;
        }
        return days;
    }

}
