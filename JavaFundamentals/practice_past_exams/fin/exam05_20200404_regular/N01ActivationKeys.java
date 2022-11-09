package practice_past_exams.fin.exam05_20200404_regular;

import java.util.Scanner;

public class N01ActivationKeys {
    private static final String END = "Generate";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();

        String[] tokens = scanner.nextLine().split(">>>");
        while (!END.equals(tokens[0])) {
            switch (tokens[0]) {
                case "Contains": {
                    String subStr = tokens[1];
                    if (activationKey.contains(subStr)) {
                        System.out.printf("%s contains %s%n", activationKey, subStr);
                    } else {
                        System.out.println("Substring not found!");
                    }
                }
                break;
                case "Flip": {
                    int startIdx = Integer.parseInt(tokens[2]);
                    int endIdx = Integer.parseInt(tokens[3]);
                    String first = activationKey.substring(0, startIdx);
                    String middle = activationKey.substring(startIdx, endIdx);
                    String last = activationKey.substring(endIdx);
                    if ("Upper".equals(tokens[1])) {
                        middle = middle.toUpperCase();
                    } else if ("Lower".equals(tokens[1])) {
                        middle = middle.toLowerCase();
                    }
                    activationKey = first + middle + last;
                    System.out.println(activationKey);
                }
                break;
                case "Slice": {
                    int startIdx = Integer.parseInt(tokens[1]);
                    int endIdx = Integer.parseInt(tokens[2]);
                    String first = activationKey.substring(0, startIdx);
                    String last = activationKey.substring(endIdx);
                    activationKey = first + last;
                    System.out.println(activationKey);
                }
                break;
            }
            tokens = scanner.nextLine().split(">>>");
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}
