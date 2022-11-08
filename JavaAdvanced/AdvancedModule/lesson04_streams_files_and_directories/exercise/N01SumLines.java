package lesson04_streams_files_and_directories.exercise;

import lesson04_streams_files_and_directories.lab.Resources;

import java.io.*;

public class N01SumLines {
    public static void main(String[] args) throws IOException {
        String path = Resources.PATH + "input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line.codePoints().reduce(Integer::sum).orElse(0));
            line = reader.readLine();
        }
    }
}
