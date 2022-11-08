package lesson04_streams_files_and_directories.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class N05LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Resources.PATH.concat("inputLineNumbers.txt")));
        int counter = 0;
        List<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            lines.add(String.format("%d. %s", ++counter, line));
            line = reader.readLine();
        }
        reader.close();

        PrintWriter writer = new PrintWriter(new FileWriter(Resources.PATH.concat("output.txt")));
        for (String numberedLine : lines) {
            writer.println(numberedLine);
        }
        writer.close();
    }
}
