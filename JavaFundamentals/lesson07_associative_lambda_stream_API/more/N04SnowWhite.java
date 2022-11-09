package lesson07_associative_lambda_stream_API.more;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N04SnowWhite {
    private static final String END = "Once upon a time";
    //You must order the dwarfs by physics in descending order
    //and then by the total count of dwarfs with the same hat color in descending order.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Dwarf> dwarves = getDwarfList(scanner);

        dwarves.stream()
                .sorted((dwarf1, dwarf2) -> {
                    int physics1 = dwarf1.getPhysics();
                    int physics2 = dwarf2.getPhysics();
                    if (physics1 == physics2) {
                        long sameHats1 = dwarves.stream().filter(dw -> dw.getHatColor().equals(dwarf1.getHatColor())).count();
                        long sameHats2 = dwarves.stream().filter(dw -> dw.getHatColor().equals(dwarf2.getHatColor())).count();
                        return Long.compare(sameHats2, sameHats1);
                    }
                    return Integer.compare(physics2, physics1);
                })
                .forEach(System.out::println);
    }

    private static List<Dwarf> getDwarfList(Scanner scanner) {
        List<Dwarf> dwarves = new ArrayList<>();
        String input = scanner.nextLine();
        while (!END.equals(input)) {
            String[] tokens = input.split(" <:> ");
            String newName = tokens[0];
            String newHatColor = tokens[1];
            int newPhysics = Integer.parseInt(tokens[2]);

            dwarves.stream()
                    .filter(dw -> dw.getName().equals(newName) && dw.getHatColor().equals(newHatColor))
                    .findFirst()
                    .map(dw -> {
                        if (dw.getPhysics() < newPhysics) dw.setPhysics(newPhysics);
                        return dw;
                    }).orElseGet(() -> {
                        Dwarf dw = new Dwarf(newName, newHatColor, newPhysics);
                        dwarves.add(dw);
                        return dw;
                    });
            input = scanner.nextLine();
        }
        return dwarves;
    }

    private static class Dwarf {
        String name;
        String hatColor;
        int physics;

        public Dwarf(String name, String hat, int physics) {
            this.name = name;
            this.hatColor = hat;
            this.physics = physics;

        }

        public String getName() {
            return name;
        }

        public String getHatColor() {
            return hatColor;
        }

        public int getPhysics() {
            return physics;
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }

        @Override
        public String toString() {
            return String.format("(%s) %s <-> %d", hatColor, name, physics);
        }
    }
}
