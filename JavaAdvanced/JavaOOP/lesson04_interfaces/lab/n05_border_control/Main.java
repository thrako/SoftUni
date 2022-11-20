package lesson04_interfaces.lab.n05_border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String END = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final List<Identifiable> identifiables = new ArrayList<>();
        String line = scanner.nextLine();
        while (!END.equals(line)) {
            final String[] lineParts = line.split("\\s+");
            Identifiable identifiable = null;
            switch (lineParts.length) {
                case 2: {
                    final String model = lineParts[0];
                    final String id = lineParts[1];
                    identifiable = new Robot(model, id);
                    break;
                }
                case 3: {
                    final String name = lineParts[0];
                    final int age = Integer.parseInt(lineParts[1]);
                    final String id = lineParts[2];
                    identifiable = new Citizen(name, age, id);
                    break;
                }
            }
            if (identifiable != null) {
                identifiables.add(identifiable);
            }
            line = scanner.nextLine();
        }

        final String fakeIdSuffix = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIdSuffix))
                .forEach(System.out::println);
    }

}
