package lesson06_objects.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class N07OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            persons.add(new Person(input.split("\\s+")));
            input = scanner.nextLine();
        }
        persons.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
    }

    private static class Person {
        private final String name;
        private final int id;
        private final int age;

        public Person(String[] args) {
            this.name = args[0];
            this.id = Integer.parseInt(args[1]);
            this.age = Integer.parseInt(args[2]);
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s with ID: %d is %d years old.",
                    this.name, this.id, this.age
            );
        }
    }
}
