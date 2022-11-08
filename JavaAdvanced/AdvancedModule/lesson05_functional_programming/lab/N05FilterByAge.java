package lesson05_functional_programming.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N05FilterByAge {
    private static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String[] personData = scanner.nextLine().split(",\\s+");
            people.add(new Person(personData[0], Integer.parseInt(personData[1])));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        List<Person> filteredList = getFiltered(people, condition, age);
        if (filteredList != null) print(filteredList, format);
        }

    private static List<Person> getFiltered(List<Person> people, String condition, int age) {
        return ("younger".equals(condition))
                ? people.stream().filter(p -> p.getAge() <= age).collect(Collectors.toList())
                : ("older".equals(condition))
                    ? people.stream().filter(p -> p.getAge() >= age).collect(Collectors.toList())
                    : null;
    }

    private static void print(List<Person> personList, String format) {
        switch (format) {
            case "name age":
                personList.forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));
                break;
            case "name":
                personList.forEach(person -> System.out.println(person.getName()));
                break;
            case "age":
                personList.forEach(person -> System.out.println(person.getAge()));

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }
    }
}
