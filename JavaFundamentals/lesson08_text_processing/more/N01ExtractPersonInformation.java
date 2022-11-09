package lesson08_text_processing.more;

import java.util.Scanner;

public class N01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        StringBuilder strBld = new StringBuilder();
        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            String name = "", age = "";
            int length = line.length();
            for (int j = 0; j < length; j++) {
                if (line.charAt(j) == '@') {
                    int idx = j + 1;
                    while (idx < length && line.charAt(idx) != '|') strBld.append(line.charAt(idx++));
                    name = strBld.toString();
                    strBld.setLength(0);
                    j = --idx;
                } else if (line.charAt(j) == '#') {
                    int idx = j + 1;
                    while (idx < length && line.charAt(idx) != '*') strBld.append(line.charAt(idx++));
                    age = strBld.toString();
                    strBld.setLength(0);
                    j = --idx;
                }
            }
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
