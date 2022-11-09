package lesson06_objects.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N03OpinionPoll {
    private static final int filterAge = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPersons = Integer.parseInt(scanner.nextLine());
        List<Person> personsList = new ArrayList<>();
        for (int i = 0; i < numPersons; i++) {
            String[] dataArr = scanner.nextLine().split(" ");
            personsList.add(new Person(dataArr));
        }
        personsList.stream()
                .filter(e -> e.getAge() > filterAge)
                .forEach(System.out::println);
    }
    private static class Person {
        private final String name;
        private final int age;

        public Person(String[] args) {
            this.name = args[0];
            this.age = Integer.parseInt(args[1]);
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.age);
        }
    }
}
