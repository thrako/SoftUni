package lesson06_defining_classes.exercise.N08FamilyTree;

import java.util.Scanner;

class Main {
    private static final PeopleRepository PEOPLE = new PeopleRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String soughtData = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            if (input.contains("-")) {
                String[] parentChild = input.split(" - ");
                Person parent = PEOPLE.getOrCreate(parentChild[0]);
                PEOPLE.addIfAbsent(parent);
                Person child = PEOPLE.getOrCreate(parentChild[1]);
                PEOPLE.addIfAbsent(child);
                PEOPLE.setRelation(parent, child);
            } else {
                String[] personalData = input.split(" ");
                String name = String.format("%s %s", personalData[0], personalData[1]);
                String birthDate = personalData[2];
                Person person = PEOPLE.getOrCreate(name, birthDate);
                PEOPLE.addIfAbsent(person);
            }
            input = scanner.nextLine();
        }
        Person personToPrint = PEOPLE.getOrCreate(soughtData);
        System.out.print(personToPrint.getInfo());
    }
}
