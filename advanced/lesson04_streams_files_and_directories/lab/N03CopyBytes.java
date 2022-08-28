package lesson04_streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class N03CopyBytes {
    public static void main(String[] args) throws IOException {
        String inputPath = Resources.PATH + "input.txt";
        String outputPath = Resources.PATH + "03.CopyBytesOutput.txt";
        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);
        int oneByte = inputStream.read();
        while (oneByte > -1) {
            if (oneByte != 10 && oneByte != 32) {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            } else {
                outputStream.write((char) oneByte);
            }
            oneByte = inputStream.read();
        }
    }
}
