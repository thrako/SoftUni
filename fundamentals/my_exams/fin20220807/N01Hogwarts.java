package my_exams.fin20220807;

import java.util.Scanner;

public class N01Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String spellString = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Abracadabra".equals(input)) {
            String[] tokens = input.split("\\s");
            String command = tokens[0];
            switch (command) {
                case "Abjuration":
                    spellString = spellString.toUpperCase();
                    System.out.println(spellString);
                    break;
                case "Necromancy":
                    spellString = spellString.toLowerCase();
                    System.out.println(spellString);
                    break;
                case "Illusion":
                    int idx = Integer.parseInt(tokens[1]);
                    char symbol = tokens[2].charAt(0);
                    if (isInBounds(spellString, idx)) {
                        spellString = replaceChar(spellString, idx, symbol);
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case "Divination":
                    String target = tokens[1];
                    String replacement = tokens[2];
                    if (spellString.contains(target)) {
                        spellString = spellString.replace(target, replacement);
                        System.out.println(spellString);
                    }
                    break;
                case "Alteration":
                    String subStr = tokens[1];
                    if (spellString.contains(subStr)) {
                        spellString = spellString.replace(subStr, "");
                        System.out.println(spellString);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
            }
            input = scanner.nextLine();
        }

    }

    private static String replaceChar(String spellString, int idx, char symbol) {
        StringBuilder strBld = new StringBuilder();
        for (int i = 0, length = spellString.length(); i < length; i++) {
            strBld.append((i == idx)
                    ? symbol
                    : spellString.charAt(i));
        }
        return strBld.toString();
    }

    private static boolean isInBounds(String spellString, int idx) {
        return idx >= 0 && idx < spellString.length();
    }
}
