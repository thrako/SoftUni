package lesson04_streams_files_and_directories.lab;

import java.io.File;

public class N07ListFiles {
    public static void main(String[] args) {
        File file = new File(Resources.PATH.concat("Files-and-Streams"));
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
