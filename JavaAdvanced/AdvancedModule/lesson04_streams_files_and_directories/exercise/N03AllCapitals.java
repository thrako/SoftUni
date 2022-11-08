package lesson04_streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class N03AllCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Resources.PATH.concat("input.txt")));
        List<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            lines.add(line.toUpperCase());
            line = reader.readLine();
        }
        PrintWriter writer = new PrintWriter(Resources.PATH.concat("output.txt"));
        for (String lineToWrite : lines) {
            writer.println(lineToWrite);
        }
        reader.close();
        writer.close();
    }
}
