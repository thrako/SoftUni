package lesson04_streams_files_and_directories.lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class N06SortLines {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get(Resources.PATH.concat("input.txt"));
        List<String> lines = Files.readAllLines(inputPath);
        Collections.sort(lines);
        Path outputPath = Paths.get(Resources.PATH.concat("06.SortLinesOutput.txt"));
        Files.write(outputPath, lines);
    }
}
