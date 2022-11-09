package lesson08_text_processing.exercise;

import java.util.Scanner;

public class N03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\\\");
        String[] fileExtension = tokens[tokens.length - 1].split("\\.");
        System.out.printf(
                "File name: %s%n" +
                "File extension: %s%n",
                fileExtension[0], fileExtension[1]);
    }
}
