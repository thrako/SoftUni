package practice_past_exams.fin.exam01_20200815_retake;

import java.util.Scanner;

public class N01TheImitationGame {
    private static final String END = "Decode";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        String[] instructions = scanner.nextLine().split("\\|");
        while (!END.equals(instructions[0])) {
            switch (instructions[0]) {
                case "Move": {
                    int numSymbols = Integer.parseInt(instructions[1]);
                    String first = message.substring(0, numSymbols);
                    String second = message.substring(numSymbols);
                    message = second.concat(first);
                    break;
                }
                case "Insert": {
                    int idx = Integer.parseInt(instructions[1]);
                    String first = message.substring(0, idx);
                    String second = message.substring(idx);
                    String value = instructions[2];
                    message = first.concat(value).concat(second);
                    break;
                }
                case "ChangeAll": {
                    String target = instructions[1];
                    String replacement = instructions[2];
                    message = message.replace(target, replacement);
                    break;
                }
                default:
            }
            instructions = scanner.nextLine().split("\\|");
        }
        System.out.printf("The decrypted message is: %s%n", message);
    }
}
