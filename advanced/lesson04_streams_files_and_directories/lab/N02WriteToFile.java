package lesson04_streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class N02WriteToFile {
    private static final Set<Character> punctuation_symbols = Set.of(',', '.', '!', '?');

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String inputPath = Resources.PATH + "input.txt";
        String outputPath = Resources.PATH + "02.WriteToFileOutput.txt";
        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);
        int oneByte = inputStream.read();
        while (oneByte > -1) {
            char oneByteAsChar = (char) oneByte;
            if (!punctuation_symbols.contains(oneByteAsChar)) {
                outputStream.write(oneByteAsChar);
            }
            oneByte = inputStream.read();
        }
    }
}
