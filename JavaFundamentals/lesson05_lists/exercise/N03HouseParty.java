package lesson05_lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>(lines);
        String name;
        for (int i = 0; i < lines; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            name = tokens[0];
            if ("is".equals(tokens[1]) && "going!".equals(tokens[2])) {
                if (!guests.contains(name)) {
                    guests.add(name);
                } else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            } else if ("is".equals(tokens[1]) && "not".equals(tokens[2]) && "going!".equals(tokens[3])) {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }

        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
