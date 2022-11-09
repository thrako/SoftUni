package lesson07_associative_lambda_stream_API.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N05SoftUniParking {
    public static void main(String[] args) {
        Map<String, String> userPlate = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        int inputsCount = Integer.parseInt(scanner.nextLine());
        String input, command, user, plate;
        String[] tokens;

        for (int i = 0; i < inputsCount; i++) {
            input = scanner.nextLine();
            tokens = input.split("\\s+");
            command = tokens[0];
            user = tokens[1];

            switch (command) {
                case "register":
                    if (userPlate.containsKey(user)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", userPlate.get(user));
                        break;
                    }
                    plate = tokens[2];
                    userPlate.put(user, plate);
                    System.out.printf("%s registered %s successfully%n", user, plate);
                    break;
                case "unregister":
                    if (!userPlate.containsKey(user)) {
                        System.out.printf("ERROR: user %s not found%n", user);
                        break;
                    }
                    userPlate.remove(user);
                    System.out.printf("%s unregistered successfully%n", user);
                    break;
            }
        }

        for (Map.Entry<String, String> entry : userPlate.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
