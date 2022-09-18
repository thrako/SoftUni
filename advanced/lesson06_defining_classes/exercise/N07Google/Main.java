package lesson06_defining_classes.exercise.N07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static final Map<String, Person> PEOPLE = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        gatherInfo(scanner);
        String personName = scanner.nextLine();
        System.out.println(PEOPLE.get(personName));
    }

    private static void gatherInfo(Scanner scanner) {
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] inputData = input.split("\\s+");
            int counter = -1;
            String name = inputData[++counter];
            PEOPLE.putIfAbsent(name, new Person(name));
            Person person = PEOPLE.get(name);
            String dataType = inputData[++counter];
            switch (dataType) {
                case "company":
                    person.setCompany(new Company(
                            /*name*/ inputData[++counter],
                            /*department*/ inputData[++counter],
                            /*salary*/ Double.parseDouble(inputData[++counter])
                    ));
                    break;
                case "pokemon":
                    person.addPokemon(new Pokemon(
                            /*name*/ inputData[++counter],
                            /*type*/ inputData[++counter]
                    ));
                    break;
                case "parents":
                    person.addParent(new Parent(
                            /*name*/ inputData[++counter],
                            /*birthday*/ inputData[++counter]
                    ));
                    break;
                case "children":
                    person.addChild(new Child(
                            /*name*/ inputData[++counter],
                            /*birthday*/ inputData[++counter]
                    ));
                    break;
                case "car":
                    person.setCar(new Car(
                            /*model*/ inputData[++counter],
                            /*speed*/ inputData[++counter]
                    ));
                    break;
            }
            input = scanner.nextLine();
        }

    }
}
