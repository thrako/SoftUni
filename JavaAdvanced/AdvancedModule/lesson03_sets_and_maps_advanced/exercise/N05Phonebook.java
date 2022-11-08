package lesson03_sets_and_maps_advanced.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N05Phonebook {
    private static final Map<String, String> PHONEBOOK = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"search".equals(input)) {
            addContact(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"stop".equals(input)) {
            System.out.println(getContactInfo(input));
            input = scanner.nextLine();
        }
    }

    private static void addContact(String input) {
        String[] InputData = input.split("-");
        String name = InputData[0];
        String number = InputData[1];
        PHONEBOOK.put(name, number);
    }

    private static String getContactInfo(String input) {
        if (PHONEBOOK.containsKey(input)) {
            return String.format("%s -> %s", input, PHONEBOOK.get(input));
        }
        return String.format("Contact %s does not exist.", input);

    }
}
