package lesson04_streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class N01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = Resources.PATH + "input.txt";
        InputStream in = new FileInputStream(path);
        int oneByte = in.read();
        while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = in.read();
        }
    }
}
