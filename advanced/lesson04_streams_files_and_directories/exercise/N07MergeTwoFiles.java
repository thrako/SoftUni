package lesson04_streams_files_and_directories.exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        List<String> mergedList = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(Resources.PATH.concat("inputOne.txt")));
        while (scanner.hasNextLine()) {
            mergedList.add(scanner.nextLine());
        }
        scanner = new Scanner(new FileReader(Resources.PATH.concat("inputTwo.txt")));
        while (scanner.hasNextLine()) {
            mergedList.add(scanner.nextLine());
        }
        scanner.close();

        PrintWriter writer = new PrintWriter(new FileWriter(Resources.PATH.concat("outputMerged.txt")));
        for (String line : mergedList) {
            writer.println(line);
        }
        writer.close();

    }
}
