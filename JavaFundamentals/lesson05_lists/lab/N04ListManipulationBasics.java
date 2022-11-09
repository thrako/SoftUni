package lesson05_lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getList(scanner);
        String[] tokens = scanner.nextLine().split(" ");
        int num, idx;

        while (!"end".equals(tokens[0])) {
            String command = tokens[0];
            switch (command) {
                case "Add":
                    num = Integer.parseInt(tokens[1]);
                    numbers.add(num);
                    break;
                case "Remove":
                    num = Integer.parseInt(tokens[1]);
                    numbers.remove((Integer) num);
                    break;
                case "RemoveAt":
                    idx = Integer.parseInt(tokens[1]);
                    numbers.remove(idx);
                    break;
                case "Insert":
                    num = Integer.parseInt(tokens[1]);
                    idx = Integer.parseInt(tokens[2]);
                    numbers.add(idx, num);
                    break;
            }
            tokens = scanner.nextLine().split(" ");
        }
        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }

    }

    private static List<Integer> getList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
