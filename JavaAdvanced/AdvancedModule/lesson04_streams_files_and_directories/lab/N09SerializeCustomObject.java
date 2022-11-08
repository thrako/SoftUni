package lesson04_streams_files_and_directories.lab;

import java.io.*;

public class N09SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube("green", 15.3, 12.4, 3);
        String pathString = Resources.PATH.concat("save.ser");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(pathString));
            outputStream.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(pathString));
            Cube cubeFromFile = (Cube) inputStream.readObject();
            System.out.println(cubeFromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class Cube implements Serializable {

        String color;
        double width;
        double height;
        double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Cube{" +
                   "color='" + color + '\'' +
                   ", width=" + width +
                   ", height=" + height +
                   ", depth=" + depth +
                   '}';
        }
    }
}

