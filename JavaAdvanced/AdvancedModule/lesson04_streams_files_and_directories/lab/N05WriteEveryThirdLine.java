package lesson04_streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class N05WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = Resources.PATH + "input.txt";
        Scanner scanner = new Scanner(new FileInputStream(inputPath));

        String outputPath = Resources.PATH + "05.WriteEveryThirdLineOutput.txt";
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            String line = scanner.nextLine();
            if (counter % 3 == 0) {
                writer.println(line);
            }
        }
        writer.close();
    }
}
