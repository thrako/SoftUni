package lesson05_lists.more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N05DrumSet {
    private static final String END = "Hit it again, Gabsy!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> powers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> prices = new ArrayList<>(powers.size());
        for (Integer power : powers) {
            prices.add(power * 3);
        }

        int hit, power;
        double price;
        List<Integer> indicesToRemove = new ArrayList<>();
        String input = scanner.nextLine();
        while (!END.equals(input)) {
            hit = Integer.parseInt(input);
            for (int i = 0, size = powers.size(); i < size; i++) {
                power = powers.get(i);
                price = prices.get(i);
                if (power > hit) {
                    powers.set(i, power - hit);
                } else if (savings > price) {
                    savings -= price;
                    powers.set(i, (int) price / 3);
                } else {
                    indicesToRemove.add(i);
                }
            }
            for (int i = indicesToRemove.size() - 1; i > -1; i--) {
                int idx = indicesToRemove.get(i);
                powers.remove(idx);
                prices.remove(idx);
            }
            indicesToRemove.clear();
            input = scanner.nextLine();
        }
        printDelimited(powers);
        System.out.printf("Gabsy has %.2flv.", savings);
    }

    private static void printDelimited(List<Integer> result) {
        int size = result.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.print(result.get(size - 1));
        System.out.println();
    }
}
