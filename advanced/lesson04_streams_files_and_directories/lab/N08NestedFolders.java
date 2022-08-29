package lesson04_streams_files_and_directories.lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class N08NestedFolders {
    public static void main(String[] args) {
        File root = new File(Resources.PATH.concat("Files-and-Streams"));
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] filesList = current.listFiles();
            if (filesList != null) {
                for (File file : filesList) {
                    if (file.isDirectory()) dirs.offer(file);
                }
            }
            System.out.println(current.getName());
            count++;
        }
        System.out.println(count + " folders");
    }
}
