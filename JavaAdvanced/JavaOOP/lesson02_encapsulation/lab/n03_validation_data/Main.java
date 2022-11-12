package lesson02_encapsulation.lab.n03_validation_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>(peopleCount);

        while (peopleCount-- > 0) {
            try {
                final String[] personData = scanner.nextLine().split(" ");
                people.add(getPerson(personData));
            } catch (IllegalPersonArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double bonus = Double.parseDouble(scanner.nextLine());
        people.forEach(p -> p.increaseSalary(bonus));

        people.forEach(System.out::println);
    }

    private static Person getPerson(String[] personData) throws IllegalPersonArgumentException {
        final var firstName = personData[0];
        final var lastName = personData[1];
        final var age = Integer.parseInt(personData[2]);
        final var bonus = Double.parseDouble(personData[3]);

        return new Person(firstName, lastName, age, bonus);
    }

}
