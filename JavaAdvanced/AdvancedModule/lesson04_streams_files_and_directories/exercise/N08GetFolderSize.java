package lesson04_streams_files_and_directories.exercise;

import java.io.File;

public class N08GetFolderSize {
    public static void main(String[] args) {
        String folderPath = Resources.PATH.concat("Exercises Resources");
        long folderSize = getDirectorySize(new File(folderPath));
        System.out.printf("Folder size: %d", folderSize);
    }

    public static long getDirectorySize(File dir) {

        long length = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile())
                    length += file.length();
                else
                    length += getDirectorySize(file);
            }
        }
        return length;
    }
}
