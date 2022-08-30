package lesson04_streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class N02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = Resources.PATH + "input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        long sum = 0;
        while (line != null) {
            sum += line.codePoints().reduce(Integer::sum).orElse(0);
            line = reader.readLine();
        }
        System.out.println(sum);
    }
}
