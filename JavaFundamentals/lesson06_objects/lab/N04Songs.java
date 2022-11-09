package lesson06_objects.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N04Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>(numberOfSongs);
        for (int i = 0; i < numberOfSongs; i++) {
            songs.add(new Song(scanner.nextLine().split("_")));
        }
        String typeSought = scanner.nextLine();
        songs.stream()
                .filter(song -> typeSought.equals("all") || typeSought.equals(song.getTypeList()))
                .forEach(song -> System.out.println(song.getName()));
    }

    static class Song {
        private final String typeList;
        private final String name;
        private final String time;

        public Song(String[] args) {
            this.typeList = args[0];
            this.name = args[1];
            this.time = args[2];
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }
    }
}

