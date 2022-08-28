package lesson04_streams_files_and_directories.lab;

import java.io.*;
import java.util.Scanner;

public class N04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String inputPath = Resources.PATH + "input.txt";
        Scanner scanner = new Scanner(new FileInputStream(inputPath));

        String outputPath = Resources.PATH + "04.ExtractIntegersOutput.txt";
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        writer.close();
    }
}
